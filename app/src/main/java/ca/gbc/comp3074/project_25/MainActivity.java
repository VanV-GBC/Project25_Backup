package ca.gbc.comp3074.project_25;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    //set fragment manager
    FragmentManager fragmentManager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //instantiate initial fragment.
        Fragment mainFragment = new MainFragment();
        // swap into main fragment
        fragmentManager.beginTransaction().replace(R.id.fragmentContainer_activity_main, mainFragment).commit();




    }



    // menu methods
    private void startAboutActivity(){
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

    private void startDetailsActivity(){
        Intent intent = new Intent(getApplicationContext(), DetailsActivity.class);
        startActivity(intent);
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

        if (item_id == R.id.menu_about){
            startAboutActivity();

        }else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }
}