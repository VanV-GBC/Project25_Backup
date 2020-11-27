package ca.gbc.comp3074.project_25.details_edit_activity;

import android.content.ContentValues;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;

import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import ca.gbc.comp3074.project_25.MapsFragment;
import ca.gbc.comp3074.project_25.MapsFragment_empty_DetailsEditActivity;
import ca.gbc.comp3074.project_25.R;
import ca.gbc.comp3074.project_25.about_activity.AboutActivity;

public class DetailsEditActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_NAME";
    public static final String EXTRA_ADDR_LINE_1 = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_ADDR_LINE_1";
    public static final String EXTRA_ADDR_LINE_2 = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_ADDR_LINE_2";
    public static final String EXTRA_CITY = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_CITY";
    public static final String EXTRA_PROVINCE = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_PROVINCE";
    public static final String EXTRA_COUNTRY = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_COUNTRY";
    public static final String EXTRA_POSTAL_CODE = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_POSTAL_CODE";
    public static final String EXTRA_PHONE_NUMBER = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_PHONE_NUMBER";
    public static final String EXTRA_DESCRIPTION = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_DESCRIPTION";
    public static final String EXTRA_EMAIL = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_EMAIL";
    public static final String EXTRA_WEBSITE = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_SMS";
    public static final String EXTRA_SMS = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_WEBSITE";
    public static final String EXTRA_LAT = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_LAT";
    public static final String EXTRA_LON = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_LON";
    public static final String EXTRA_RATING = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_WEBSITE";
    public static final String EXTRA_TAGS = "package ca.gbc.comp3074.project_25.details_edit_activity.EXTRA_WEBSITE";

    private TextInputEditText txtRestaurantName;
    private TextInputEditText txtRestaurantAddyLine1;
    private TextInputEditText txtRestaurantAddyLine2;
    private TextInputEditText txtRestaurantCity;
    private TextInputEditText txtRestaurantProvince;
    private TextInputEditText txtRestaurantCountry;
    private TextInputEditText txtRestaurantPostalCode;
    private TextInputEditText txtRestaurantPhoneNumber;
    private TextInputEditText txtRestaurantDescription;
    private TextInputEditText txtRestaurantEmail;
    private TextInputEditText txtRestaurantWebsite;
    private ImageButton btnSMS;
    private Double lat;
    private Double lon;
    EditText restaurantTags;
    ChipGroup tagsChipGroup;
    RatingBar ratingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_edit);


        TextInputEditText txtRestaurantName = (TextInputEditText) findViewById(R.id.edit_txt_restaurantName);
        TextInputEditText txtRestaurantAddyLine1 = (TextInputEditText) findViewById(R.id.edit_txt_restaurantAddyLine1);
        TextInputEditText txtRestaurantAddyLine2 = (TextInputEditText) findViewById(R.id.edit_txt_restaurantAddyLine2);
        TextInputEditText txtRestaurantCity = (TextInputEditText) findViewById(R.id.edit_txt_restaurantCity);
        TextInputEditText txtRestaurantProvince = (TextInputEditText) findViewById(R.id.edit_txt_restaurantProvince);
        TextInputEditText txtRestaurantCountry = (TextInputEditText) findViewById(R.id.edit_txt_restaurantCountry);
        TextInputEditText txtRestaurantPostalCode = (TextInputEditText) findViewById(R.id.edit_txt_restaurantPostalCode);
        TextInputEditText txtRestaurantPhoneNumber = (TextInputEditText) findViewById(R.id.edit_txt_restaurantPhoneNumber);
        TextInputEditText txtRestaurantDescription = (TextInputEditText) findViewById(R.id.edit_txt_restaurantDescription);
        TextInputEditText txtRestaurantEmail = (TextInputEditText) findViewById(R.id.edit_txt_restaurantEmail);
        TextInputEditText txtRestaurantWebsite = (TextInputEditText) findViewById(R.id.edit_txt_restaurantWebsite);
        ImageButton btnSMS = (ImageButton) findViewById(R.id.btnText);
        EditText restaurantTags = (EditText) findViewById(R.id.restaurantTags);
        RatingBar ratingBar = (RatingBar) findViewById(R.id.edit_ratingBar_restaurantRating);


        String name = txtRestaurantName.getText().toString();
        String city = txtRestaurantCity.getText().toString();
        List<Address> geoLoad = getWithInfo(name, city);
        lat = geoLoad.get(0).getLatitude();
        lon = geoLoad.get(0).getLongitude();

        // This one's tricky...will walk through

        // get Name field and set on focus change listener.
//        txtRestaurantName.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(View v, boolean hasFocus) {
//                // if loses focus
//                if(!hasFocus) {
//                    // if either name or city fields are empty
//                    if (txtRestaurantName.toString().isEmpty() && txtRestaurantCity.toString().isEmpty()) {
//                        Toast.makeText(DetailsEditActivity.this, "Both the Restaurant and City fields need to be filled to get map coordinates", Toast.LENGTH_LONG).show();
//                    }
//                    else {
//                        // Field has focus, time to set a key listener.
//                        txtRestaurantName.setOnKeyListener(new View.OnKeyListener() {
//                            @Override
//                            public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                                txtRestaurantName.setOnKeyListener(new View.OnKeyListener() {
//                                    @Override
//                                    public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//                                        if (!name.isEmpty() && !city.isEmpty()) {
//                                            geoLoad = getWithInfo(name, city);
//                                        }
//                                        return true;
//                                    }
//                                });
//
//                                return false;
//                            }
//                        });
//                    }
//
//
//                }else{
//
//                }
//            }
//        });





        // Maps related
        FragmentManager fragmentManager = getSupportFragmentManager();



        MapsFragment mapsFragment = new MapsFragment() ;
        MapsFragment_empty_DetailsEditActivity noMap = new MapsFragment_empty_DetailsEditActivity();
        // Bundle for MapsActivity
        Bundle bundle = restaurantMapBundle();

        if ( bundle.getString("restaurant_name") != null && bundle.getString("restaurant_city") != null){
            mapsFragment.setArguments(bundle);
            fragmentManager.beginTransaction().replace(R.id.fragment_container_details_map, mapsFragment).commit();
        }else{

            fragmentManager.beginTransaction().replace(R.id.fragment_container_details_map, noMap).commit();
        }

    }

    //temp coordinates for testing

    Double restaurantLat = 43.6761366;
    Double restaurantLon = -79.4104903;
    String restaurantName = "Original Grill";
    String restaurantCity = "Toronto";

    //bundle for both partial and fullscreen maps
    private Bundle restaurantMapBundle(){
        if(!restaurantLat.isNaN() && !restaurantLon.isNaN()){
            Bundle bundle = new Bundle();
            bundle.putString("restaurant_name", "Original Grill");
            bundle.putString("restaurant_city", "Toronto");
            bundle.putDouble("restaurant_lat", restaurantLat);
            bundle.putDouble("restaurant_lon", restaurantLon);
            return bundle;
        }
        return null;
    }


    //Some Geocoder stuff, might be put into its own class later

    public List<Address> getWithLatLon(Double lat, Double lon){

        Geocoder geo = new Geocoder(this, Locale.CANADA);

        try {
            List<Address> addresses = geo.getFromLocation(lat, lon, 1);
            //  Toast.makeText(DetailsEditActivity.this, addresses.toString(),Toast.LENGTH_SHORT).show();
            return addresses;
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Address> getWithInfo(String resName, String resCity) {

        String location = resName + ", " + resCity;
        Geocoder geo = new Geocoder(this, Locale.CANADA);

        try {
            List<Address> addresses = geo.getFromLocationName(location, 1);
            Toast.makeText(DetailsEditActivity.this, addresses.toString(), Toast.LENGTH_LONG).show();
            return addresses;
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }

    }
    // Geocoder done


    // Menu Stuff
    private void startDetailsActivity(){


        String Name = txtRestaurantName.getText().toString();
        String AddyLine1 = txtRestaurantAddyLine1.getText().toString();
        String AddyLine2 = txtRestaurantAddyLine2.getText().toString();
        String City = txtRestaurantCity.getText().toString();
        String Province = txtRestaurantProvince.getText().toString();
        String PostalCode = txtRestaurantPostalCode.getText().toString();
        String Country = txtRestaurantCountry.getText().toString();
        String PhoneNumber = txtRestaurantPhoneNumber.getText().toString();
        String Description = txtRestaurantDescription.getText().toString();
        String Email = txtRestaurantEmail.getText().toString();
        String Sms = txtRestaurantAddyLine1.getText().toString();
        String Website = txtRestaurantWebsite.getText().toString();
        Double Lat = lat;
        Double Lon = lon;
        Float rating = ratingBar.getRating();

        if(Name.trim().isEmpty() || City.trim().isEmpty()){
            Toast.makeText(this, "You need to input at least a Restaurant name and city to save", Toast.LENGTH_LONG);
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_NAME, Name);
        data.putExtra(EXTRA_ADDR_LINE_1, AddyLine1);
        data.putExtra(EXTRA_ADDR_LINE_2, AddyLine2);
        data.putExtra(EXTRA_CITY, City);
        data.putExtra(EXTRA_PROVINCE, Province);
        data.putExtra(EXTRA_POSTAL_CODE, PostalCode);
        data.putExtra(EXTRA_COUNTRY, Country);
        data.putExtra(EXTRA_PHONE_NUMBER, PhoneNumber);
        data.putExtra(EXTRA_DESCRIPTION, Description);
        data.putExtra(EXTRA_EMAIL, Email);
        data.putExtra(EXTRA_SMS, Sms);
        data.putExtra(EXTRA_WEBSITE, Website);
        data.putExtra(EXTRA_LAT, Lat);
        data.putExtra(EXTRA_LON, Lon);
        data.putExtra(EXTRA_RATING, rating);

        setResult(RESULT_OK,data);
        finish();


//        List<Integer> chip = tagsChipGroup.getCheckedChipIds();


//        TextInputEditText txtRestaurantName = (TextInputEditText) findViewById(R.id.edit_txt_restaurantName);
//        TextInputEditText txtRestaurantAddyLine1 = (TextInputEditText) findViewById(R.id.edit_txt_restaurantAddyLine1);
//        TextInputEditText txtRestaurantAddyLine2 = (TextInputEditText) findViewById(R.id.edit_txt_restaurantAddyLine2);
//        TextInputEditText txtRestaurantCity = (TextInputEditText) findViewById(R.id.edit_txt_restaurantCity);
//        TextInputEditText txtRestaurantProvince = (TextInputEditText) findViewById(R.id.edit_txt_restaurantProvince);
//        TextInputEditText txtRestaurantCountry = (TextInputEditText) findViewById(R.id.edit_txt_restaurantCountry);
//        TextInputEditText txtRestaurantPostalCode = (TextInputEditText) findViewById(R.id.edit_txt_restaurantPostalCode);
//        TextInputEditText txtRestaurantPhoneNumber = (TextInputEditText) findViewById(R.id.edit_txt_restaurantPhoneNumber);
//        TextInputEditText txtRestaurantDescription = (TextInputEditText) findViewById(R.id.edit_txt_restaurantDescription);
//        TextInputEditText txtRestaurantEmail = (TextInputEditText) findViewById(R.id.edit_txt_restaurantEmail);
//        TextInputEditText txtRestaurantWebsite = (TextInputEditText) findViewById(R.id.edit_txt_restaurantWebsite);
//        ImageButton btnSMS = (ImageButton) findViewById(R.id.btnText);
//        EditText restaurantTags = (EditText) findViewById(R.id.restaurantTags);
//        RatingBar ratingBar = (RatingBar) findViewById(R.id.edit_ratingBar_restaurantRating);
//
//        ContentValues values = new ContentValues();
//        values.put(RestaurantProvider.NAME, txtRestaurantName.getText().toString());
//        values.put(RestaurantProvider.ADDRESS_LINE_1, txtRestaurantName.getText().toString());
//        values.put(RestaurantProvider.ADDRESS_LINE_2, txtRestaurantName.getText().toString());
//        values.put(RestaurantProvider.CITY, txtRestaurantName.getText().toString());
//        values.put(RestaurantProvider.POSTAL_CODE, txtRestaurantName.getText().toString());
//        values.put(RestaurantProvider.PROVINCE, txtRestaurantName.getText().toString());
//

//        RestaurantManager restaurantManager = new RestaurantManager();
//
//        RestaurantItem restaurantItem = new RestaurantItem();
//
//        String[] tags = {"Van Restaurant", "sample tags", "for now"};
//        restaurantItem.setName(txtRestaurantName.toString());
//        restaurantItem.setAddress1(txtRestaurantAddyLine1.toString());
//        restaurantItem.setAddress2(txtRestaurantAddyLine2.toString());
//        restaurantItem.setCity(txtRestaurantCity.toString());
//        restaurantItem.setCountry(txtRestaurantCountry.toString());
//        restaurantItem.setProvince(txtRestaurantProvince.toString());
//        restaurantItem.setEmail(txtRestaurantEmail.toString());
//        restaurantItem.setWebsite(txtRestaurantWebsite.toString());
//        restaurantItem.setDescription(txtRestaurantDescription.toString());
//
//        restaurantItem.setLatitude(43.6761366);
//        restaurantItem.setLongitude(-79.4104903);
//        restaurantItem.setTags(tags);
//
//        restaurantManager.modifyRestaurant(restaurantItem);
//        //  Toast.makeText(DetailsEditActivity.this,uri.toString(),Toast.LENGTH_SHORT).show();

//        Intent intent = new Intent( getApplicationContext(), DetailsActivity.class);
//        startActivity(intent);



    }

    private void startAboutActivity(){
        Intent intent = new Intent( getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inf = getMenuInflater();
       inf.inflate(R.menu.details_edit_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int item_id = item.getItemId();

        if (item_id == R.id.menu_details_save){

            startDetailsActivity();

        }
        else if (item_id == R.id.menu_details_about){
            startAboutActivity();
        }
        else{
            return super.onOptionsItemSelected(item);
        }
        return true;
    }




}