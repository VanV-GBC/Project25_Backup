package ca.gbc.comp3074.project_25.main_activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
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
                Toast.makeText(MainActivity.this,"Exxxxcellent", Toast.LENGTH_LONG).show();
                adapter.setRestaurants(restaurants);
            }
        });

    }


    // menu methods
    private void startAboutActivity(){
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }


/*    Bundle b = new Bundle();
    int id = -1;
    private void startDetailsEditActivity(){
        Intent intent = new Intent(getApplicationContext(), DetailsEditActivity.class);

        b.putInt("id", id);
        intent.putExtras(b);
        startActivity(intent);
    }*/



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
           // startDetailsEditActivity();
        }else if (item_id == R.id.menu_about){
            startAboutActivity();
        }else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}