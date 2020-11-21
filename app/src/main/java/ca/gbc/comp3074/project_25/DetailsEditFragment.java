package ca.gbc.comp3074.project_25;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import java.lang.reflect.Array;

public class DetailsEditFragment extends Fragment {

    //
//    public DetailsEditFragment() {
//        // Required empty public constructor
//    }


    //Fragment detailsViewFragment = new DetailsViewFragment();

    private RestaurantViewModel viewModel;

    private EditText restaurantName;
    private EditText restaurantAddyLine1;
    private EditText restaurantAddyLine2;
    private EditText restaurantCity;
    private EditText restaurantPostalCode;
    private EditText restaurantProvince;
    private EditText restaurantCountry;
    private EditText restaurantPhoneNumber;
    private EditText restaurantEmail;
    private Double restaurantLat;
    private Double restaurantLon;
    private RatingBar restaurantRating;  // might change to Float, not sure?
    private Array restaurantTags;

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Creating view instance
        View view = inflater.inflate(R.layout.fragment_details_view, container, false);





        //Map Partial
        Fragment mapsFragment = new MapsFragment();
        FragmentManager childFragManager = getChildFragmentManager();



        // Getting fields from said instance
        TextInputEditText txtRestaurantName = (TextInputEditText) view.findViewById(R.id.txt_restaurant_name);
        TextInputEditText txtRestaurantAddyLine1 = (TextInputEditText) view.findViewById(R.id.txt_restaurant_addr_l1);
        TextInputEditText txtRestaurantAddyLine2 = (TextInputEditText) view.findViewById(R.id.txt_restaurant_addr_l2);
        TextInputEditText txtRestaurantCity = (TextInputEditText) view.findViewById(R.id.txt_restaurant_city);
        TextInputEditText txtRestaurantPostalCode = (TextInputEditText) view.findViewById(R.id.txt_restaurant_postal_code);
        TextInputEditText txtRestaurantProvince = (TextInputEditText) view.findViewById(R.id.txt_restaurant_province);
        TextInputEditText txtRestaurantCountry = (TextInputEditText) view.findViewById(R.id.txt_restaurant_country);
        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.restaurant_rating);

        //
//        viewModel.setText(restaurantName.getText());
//        txtRestaurantAddyLine1.setText(restaurantAddyLine1);
//        txtRestaurantAddyLine2.setText(restaurantAddyLine2);
//        txtRestaurantCity.setText(restaurantCity);
//        txtRestaurantPostalCode.setText(restaurantPostalCode);
//        txtRestaurantProvince.setText(restaurantProvince);
//        txtRestaurantCountry.setText(restaurantCountry);
//        ratingBar.setRating(restaurantRating);

        // Bundle for MapsActivity
        Bundle bundle = restaurantMapBundle();

        if (bundle!= null){
            mapsFragment.setArguments(bundle);

            childFragManager.beginTransaction().replace(R.id.fragment_container_details_map, mapsFragment).commit();
        }

        return view;


    }

    //bundle for both partial and fullscreen maps
    private Bundle restaurantMapBundle (){
//        if(!restaurantLat.isEmpty() && !restaurantLon.isEmpty()){
//            Bundle bundle = new Bundle();
//            bundle.putString("restaurant_name", "Original Grill");
//            bundle.putString("restaurant_lat", restaurantLat);
//            bundle.putString("restaurant_lon", restaurantLon);
//            return bundle;
//        }

        return null;
    }

//    private void saveEntry(){
//
//        getParentFragmentManager().beginTransaction().replace(R.id.fragmentContainer_activity_details, detailsViewFragment).addToBackStack("null").commit();
//
//    }


//    private void startAboutActivity(){
//        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
//        startActivity(intent);
//    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.details_edit_menu, menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int item_id = item.getItemId();

        if (item_id == R.id.menu_details_save) {

//            saveEntry();
        }
        else if (item_id == R.id.menu_details_about){
            //startAboutActivity();
        }
        else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }



}