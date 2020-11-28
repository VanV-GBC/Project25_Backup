package ca.gbc.comp3074.project_25.main_activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ca.gbc.comp3074.project_25.R;
import ca.gbc.comp3074.project_25._restaurant.Restaurant;
import ca.gbc.comp3074.project_25.about_activity.AboutActivity;
import ca.gbc.comp3074.project_25.details_edit_activity.DetailsEditActivity;

public class MainActivity extends AppCompatActivity {

    public static final int ADD_RESTAURANT_REQUEST = 1;
    private RestaurantsListViewModel restaurantsListViewModel;

    //set fragment manager
   // FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FloatingActionButton lowerAddBtn = findViewById(R.id.button_add_restaurant);
        lowerAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailsEditActivity.class);
                startActivityForResult(intent, ADD_RESTAURANT_REQUEST);
            }
        });

        FloatingActionButton deleteAllBtn = findViewById(R.id.button_delete_all);
        deleteAllBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restaurantsListViewModel.deleteAllRestaurants();
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


        CardDataAdapter adapter = new CardDataAdapter();
        recyclerView.setAdapter(adapter);

        restaurantsListViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(RestaurantsListViewModel.class);

        restaurantsListViewModel.getAllRestaurants().observe(this, new Observer<List<Restaurant>>() {
            @Override
            public void onChanged(List<Restaurant> restaurants) {
                Toast.makeText(MainActivity.this,"List Updated", Toast.LENGTH_LONG).show();
                adapter.setRestaurants(restaurants);
            }
        });

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT ) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                restaurantsListViewModel.delete(adapter.getRestaurantAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Restaurant Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);



    }
    // onCreate END


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Date datetime  = Calendar.getInstance().getTime();
        if(requestCode == ADD_RESTAURANT_REQUEST && resultCode == RESULT_OK){
            String name = data.getStringExtra(DetailsEditActivity.EXTRA_NAME);
            String address_line_1 = data.getStringExtra(DetailsEditActivity.EXTRA_ADDR_LINE_1);
            String address_line_2 = data.getStringExtra(DetailsEditActivity.EXTRA_ADDR_LINE_2);
            String city = data.getStringExtra(DetailsEditActivity.EXTRA_CITY);
            String postal_code = data.getStringExtra(DetailsEditActivity.EXTRA_POSTAL_CODE);
            String province = data.getStringExtra(DetailsEditActivity.EXTRA_PROVINCE);
            String country = data.getStringExtra(DetailsEditActivity.EXTRA_COUNTRY);
            String phone_number = data.getStringExtra(DetailsEditActivity.EXTRA_PHONE_NUMBER);
            String email = data.getStringExtra(DetailsEditActivity.EXTRA_EMAIL);
            String website = data.getStringExtra(DetailsEditActivity.EXTRA_WEBSITE);
            String description = data.getStringExtra(DetailsEditActivity.EXTRA_NAME);
            String sms = data.getStringExtra(DetailsEditActivity.EXTRA_SMS);
            Double lat = data.getDoubleExtra(DetailsEditActivity.EXTRA_LAT, 0.0);
            Double lon = data.getDoubleExtra(DetailsEditActivity.EXTRA_LON, 0.0);
            Float rating = data.getFloatExtra(DetailsEditActivity.EXTRA_RATING, 0f);
            List<String> tags = data.getStringArrayListExtra(DetailsEditActivity.EXTRA_TAGS);

            Restaurant restaurant = new Restaurant(
                    name,
                    address_line_1,
                    address_line_2,
                    city,
                    postal_code,
                    province,country,
                    phone_number,
                    email,
                    website,
                    description,
                    sms,
                    lat,
                    lon,
                    rating,
                    tags,
                    datetime,
                    datetime
            );

            restaurantsListViewModel.insert(restaurant);
            Toast.makeText(this,"Restaurant " + name + " in " + city + ", "+ province + " Added.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"Restaurant not Added.", Toast.LENGTH_LONG).show();
        }
    }

    // menu methods
    private void startAboutActivity(){
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }


    private void startDetailsEditActivity(){
        Intent intent = new Intent(MainActivity.this, DetailsEditActivity.class);
        startActivityForResult(intent, ADD_RESTAURANT_REQUEST);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.main_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int item_id = item.getItemId();

        if (item_id == R.id.menu_details_edit) {
            startDetailsEditActivity();
        }else if (item_id == R.id.menu_about){
            startAboutActivity();
        }else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}