package ca.gbc.comp3074.project_25.details_edit_activity;

//import ca.gbc.comp3074.project_25.details_activity.DetailsViewFragment;


//public class DetailsEditFragment extends Fragment {
//    private DetailsEditFragmentListener listener;
//    private Button buttonOk;
//
//    public interface DetailsEditListener{
//        void onDetailsSent(Bundle bundle);
//    }
//
//
//    public DetailsEditFragment() {
//        // Required empty public constructor
//    }
//
//
//    Fragment detailsViewFragment = new DetailsViewFragment();
//
//
//    private RestaurantsListViewModel viewModel;
//
//
//    private EditText restaurantName;
//    private EditText restaurantAddyLine1;
//    private EditText restaurantAddyLine2;
//    private EditText restaurantCity;
//    private EditText restaurantPostalCode;
//    private EditText restaurantProvince;
//    private EditText restaurantCountry;
//    private EditText restaurantPhoneNumber;
//    private EditText restaurantEmail;
//    private EditText restaurantWebsite;
//    private EditText restaurantDescription;
//    private Double restaurantLat;
//    private Double restaurantLon;
//    private Float restaurantRating;  // might change to Float, not sure?
//    private String restaurantTags;
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setHasOptionsMenu(true);
//
//    }
//
//    public interface DetailsEditFragmentListener {
//        void onDetailsEditSent(CharSequence input);
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//        // Creating view instance
//        View view = inflater.inflate(R.layout.fragment_details_view, container, false);
//
//
//
//
//
//        //Map Partial
//        Fragment mapsFragment = new MapsFragment();
//        FragmentManager childFragManager = getChildFragmentManager();
//
//
//        // Getting fields from said instance
//        TextInputEditText txtRestaurantName = (TextInputEditText) view.findViewById(R.id.edit_txt_restaurantName);
//        TextInputEditText txtRestaurantAddyLine1 = (TextInputEditText) view.findViewById(R.id.edit_txt_restaurantAddyLine1);
//        TextInputEditText txtRestaurantAddyLine2 = (TextInputEditText) view.findViewById(R.id.edit_txt_restaurantAddyLine2);
//        TextInputEditText txtRestaurantCity = (TextInputEditText) view.findViewById(R.id.edit_txt_restaurantCity);
//        TextInputEditText txtRestaurantPostalCode = (TextInputEditText) view.findViewById(R.id.edit_txt_restaurantPostalCode);
//        TextInputEditText txtRestaurantProvince = (TextInputEditText) view.findViewById(R.id.edit_txt_restaurantProvince);
//        TextInputEditText txtRestaurantCountry = (TextInputEditText) view.findViewById(R.id.edit_txt_restaurantCountry);
//        TextInputEditText txtRestaurantPhoneNumber = (TextInputEditText) view.findViewById(R.id.edit_txt_restaurantPhoneNumber);
//        TextInputEditText txtRestaurantEmail = (TextInputEditText) view.findViewById(R.id.edit_txt_restaurantEmail);
//        TextInputEditText txtRestaurantWebsite = (TextInputEditText) view.findViewById(R.id.edit_txt_restaurantWebsite);
//        TextInputEditText txtRestaurantDescription = (TextInputEditText) view.findViewById(R.id.edit_txt_restaurantDescription);
//
//        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.edit_ratingBar_restaurant_rating);
//
//        /*
//        txtRestaurantAddyLine1.setText(restaurantAddyLine1);
//        txtRestaurantAddyLine2.setText(restaurantAddyLine2);
//        txtRestaurantCity.setText(restaurantCity);
//        txtRestaurantPostalCode.setText(restaurantPostalCode);
//        txtRestaurantProvince.setText(restaurantProvince);
//        txtRestaurantCountry.setText(restaurantCountry);
//        ratingBar.setRating(restaurantRating);
//*/
//        // Bundle for MapsActivity
//        Bundle bundle = restaurantBundle();
//
//        if (bundle!= null){
//            mapsFragment.setArguments(bundle);
//
//            childFragManager.beginTransaction().replace(R.id.fragment_container_details_map, mapsFragment).commit();
//        }
//
//        return view;
//
//
//    }
//
//    //bundle for both partial and fullscreen maps
//    private Bundle restaurantBundle (){
//        if(!restaurantLat.isNaN() && !restaurantLon.isNaN()){
//            Bundle bundle = new Bundle();
//            bundle.putString("restaurant_name", "Original Grill");
//            bundle.putDouble("restaurant_lat", restaurantLat);
//            bundle.putDouble("restaurant_lon", restaurantLon);
//            return bundle;
//        }
//
//        return null;
//    }
//
////    private void saveEntry(){
////
////        getParentFragmentManager().beginTransaction().replace(R.id.fragmentContainer_activity_details, detailsViewFragment).addToBackStack("null").commit();
////
////    }
//
//
////    private void startAboutActivity(){
////        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
////        startActivity(intent);
////    }
//
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//
//        inflater.inflate(R.menu.details_edit_menu, menu);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int item_id = item.getItemId();
//
//        if (item_id == R.id.menu_details_save) {
//
////            saveEntry();
//        }
//        else if (item_id == R.id.menu_details_about){
//            //startAboutActivity();
//        }
//        else{
//            return super.onOptionsItemSelected(item);
//        }
//        return true;
//    }
//
//
//
//}