package ca.gbc.comp3074.project_25.details_activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import ca.gbc.comp3074.project_25.MapsFragment;
import ca.gbc.comp3074.project_25.details_edit_activity.DetailsEditActivity;
import ca.gbc.comp3074.project_25.R;
import ca.gbc.comp3074.project_25.about_activity.AboutActivity;

public class DetailsActivity extends AppCompatActivity {

//    Fragment detailsViewFragment = new DetailsViewFragment();
//    Fragment detailsEditFragment = new DetailsEditFragment();
//    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

//
//        detailsViewFragment.setArguments(makeSampleBundle());
//
//        fragmentManager.beginTransaction().replace(R.id.fragmentContainer_activity_details, detailsViewFragment).addToBackStack("null").commit();
//
//        MapsFragment mapsFragment = new MapsFragment() ;
//        MapsFragment_empty_DetailsActivity noMap = new MapsFragment_empty_DetailsActivity();
//
//        // Bundle for MapsActivity
//        Bundle bundle = restaurantMapBundle();
//
//        if ( bundle.getString("restaurant_name") != null && bundle.getString("restaurant_city") != null){
//            mapsFragment.setArguments(bundle);
//            fragmentManager.beginTransaction().replace(R.id.fragment_container_details_map, mapsFragment).commit();
//        }else{
//            fragmentManager.beginTransaction().replace(R.id.fragment_container_details_map, noMap).commit();
//        }
    }

    // menu methods
    private void startMapActivity(Bundle bundle_for_MapsActivity){
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        intent.putExtra("bundle_from_DetailsActivity", bundle_for_MapsActivity);
        startActivity(intent);
       }


    private Bundle makeSampleBundle(){
        Bundle bundle = new Bundle();

        bundle.putInt("restaurant_id", 1);
        bundle.putString("restaurant_name", "Original Grill");
        bundle.putString("restaurant_address_line_1", "22 Test St.");
        bundle.putString("restaurant_address_line_2", "Unit 3");
        bundle.putString("restaurant_city", "Toronto");
        bundle.putString("restaurant_postal_code", "m5m5m5");
        bundle.putString("restaurant_province", "ON");
        bundle.putString("restaurant_country", "Canada");
        bundle.putString("restaurant_phone_number", "4164390000");
        bundle.putString("restaurant_email", "some.restaurant@gmail.com");
        bundle.putFloat("restaurant_rating", 4.5f);
        bundle.putString("restaurant_lat", "43.6723899");
        bundle.putString("restaurant_lon", "-79.4117368");
        String[] tags = {"Mexican ", "Thai", "Italian"};
        bundle.putStringArray("restaurant_tags", tags);

        return bundle;

    }

}