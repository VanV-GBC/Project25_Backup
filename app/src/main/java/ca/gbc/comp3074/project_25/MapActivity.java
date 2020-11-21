package ca.gbc.comp3074.project_25;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.View;

public class MapActivity extends AppCompatActivity {


    Fragment mapFullScreenFragment = new MapsFragment();
    //set fragment manager
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Bundle data = getIntent().getExtras();




        //instantiate initial fragment.
        Fragment mapsFragment = new MapsFragment();
        mapsFragment.setArguments(data);

        // swap into map fragment - full screen
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer_activity_map, mapsFragment).commit();


    }

    // logic to go back to appropriate place

    // logic to enable directions


}