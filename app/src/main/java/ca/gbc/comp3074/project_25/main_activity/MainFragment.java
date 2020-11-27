package ca.gbc.comp3074.project_25.main_activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ca.gbc.comp3074.project_25.R;

public class MainFragment extends Fragment {


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        //instantiating viewModelProvider
        new ViewModelProvider(this).get(RestaurantsListViewModel.class);

        // Sample Data .... send this data [from db in later ver] to
        // DetailsFragment or DetailsActivity

        // This data should be fetched by specific id either through keyword search, or
        // through tags search.
        // not doing anything with it for now
//        bundle.putInt("restaurant_id", 1);
//        bundle.putString("restaurant_name", "Some Restaurant");
//        bundle.putString("restaurant_address_line_1", "22 Spadina Ave.");
//        bundle.putString("restaurant_address_line_2", "");
//        bundle.putString("restaurant_city", "Toronto");
//        bundle.putString("restaurant_postal_code", "b1b1b1");
//        bundle.putString("restaurant_province", "On");
//        bundle.putString("restaurant_country", "Canada");
//        bundle.putString("restaurant_phone_number", "4164390000");
//        bundle.putString("restaurant_email", "some.restaurant@gmail.com");
//        bundle.putDouble("restaurant_rating", 4.5);
//
//        String[] tags = {"Mexican ", "Thai", "Italian"};
//
//        bundle.putStringArray("restaurant_tags", tags);






        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);




    }
}