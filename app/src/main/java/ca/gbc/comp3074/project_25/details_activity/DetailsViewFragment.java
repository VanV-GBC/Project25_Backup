package ca.gbc.comp3074.project_25.details_activity;

//
//
//public class DetailsViewFragment extends Fragment {
//
//    private RestaurantsListViewModel viewModel;
//
//    //FragmentManager fragmentManager = getSupportFragmentManager();
//
//    public DetailsViewFragment() {
//        // Required empty public constructor
//    }
//
//
//
//    //private Integer restaurantId;
//    private String restaurantName;
//    private String restaurantAddressLine1;
//    private String restaurantAddressLine2;
//    private String restaurantCity;
//    private String restaurantPostalCode;
//    private String restaurantProvince;
//    private String restaurantCountry;
//    private String restaurantPhoneNumber;
//    private String restaurantEmail;
//    private String restaurantWebsite;
//    private String restaurantDescription;
//    private String restaurantLat;
//    private String restaurantLon;
//    private Float restaurantRating;
//    private String[] restaurantTags;
//
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//
//
//
//        // getting Data from MainActivity/MainFragment.
//        // dummy data for now, filling all fields.
//        // later will get only id, and then fetch data from db through it as the identifier
//        if (getArguments() != null) {
//            //restaurantId = getArguments().getInt("restaurant_id");
//            restaurantName = getArguments().getString("restaurant_name");
//            restaurantAddressLine1 = getArguments().getString("restaurant_address_line_1");
//            restaurantAddressLine2 = getArguments().getString("restaurant_address_line_2");
//            restaurantCity = getArguments().getString("restaurant_city");
//            restaurantPostalCode = getArguments().getString("restaurant_postal_code");
//            restaurantProvince = getArguments().getString("restaurant_province");
//            restaurantCountry = getArguments().getString("restaurant_country");
//            restaurantPhoneNumber = getArguments().getString("restaurant_phone_number");
//            restaurantEmail = getArguments().getString("restaurant_email");
//            restaurantLat = getArguments().getString("restaurant_lat");
//            restaurantLon = getArguments().getString("restaurant_lon");
//            restaurantRating = getArguments().getFloat("restaurant_rating");
//            restaurantTags = getArguments().getStringArray("restaurant_tags");
//
//        }
//
//        setHasOptionsMenu(true);
//    }
//
//
//
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//
//
//        Fragment mapsFragment = new MapsFragment();
//        FragmentManager childFragManager = getChildFragmentManager();
//
//        // Creating view instance
//        View view = inflater.inflate(R.layout.fragment_details_view, container, false);
//
//        // Getting fields from said instance
//        TextView txtRestaurantName = (TextView) view.findViewById(R.id.view_txt_restaurantName);
//        TextView txtRestaurantAddyLine1 = (TextView) view.findViewById(R.id.view_txt_restaurantAddyLine1);
//        TextView txtRestaurantAddyLine2 = (TextView) view.findViewById(R.id.view_txt_restaurantAddyLine2);
//        TextView txtRestaurantCity = (TextView) view.findViewById(R.id.view_txt_restaurantCity);
//        TextView txtRestaurantPostalCode = (TextView) view.findViewById(R.id.view_txt_restaurantPostalCode);
//        TextView txtRestaurantProvince = (TextView) view.findViewById(R.id.view_txt_restaurantProvince);
//        TextView txtRestaurantCountry = (TextView) view.findViewById(R.id.view_txt_restaurantCountry);
//        TextView txtRestaurantPhoneNumber = (TextView) view.findViewById(R.id.view_txt_restaurantPhoneNumber);
//        TextView txtRestaurantEmail = (TextView) view.findViewById(R.id.view_txt_restaurantEmail);
//        TextView txtRestaurantWebsite = (TextView) view.findViewById(R.id.view_txt_restaurantWebsite);
//        TextView txtRestaurantDescription = (TextView) view.findViewById(R.id.view_txt_restaurantDescription);
//
//        RatingBar ratingBar = (RatingBar) view.findViewById(R.id.view_ratingBar_restaurant_rating);
//
//        // Setting values from bundle. For now from hardcoded data, later from db.
//        txtRestaurantName.setText(restaurantName);
//        txtRestaurantAddyLine1.setText(restaurantAddressLine1);
//        txtRestaurantAddyLine2.setText(restaurantAddressLine2);
//        txtRestaurantCity.setText(restaurantCity);
//        txtRestaurantPostalCode.setText(restaurantPostalCode);
//        txtRestaurantProvince.setText(restaurantProvince);
//        txtRestaurantCountry.setText(restaurantCountry);
//        ratingBar.setRating(restaurantRating);
//        txtRestaurantPhoneNumber.setText(restaurantPhoneNumber);
//        txtRestaurantEmail.setText(restaurantEmail);
//        txtRestaurantWebsite.setText(restaurantWebsite);
//        txtRestaurantDescription.setText(restaurantDescription);
//
//
//        // Bundle for MapsActivity
//        Bundle bundle = restaurantMapBundle();
//
//        if (bundle!= null){
//            mapsFragment.setArguments(bundle);
//
//            childFragManager.beginTransaction().replace(R.id.fragment_container_details_map, mapsFragment).commit();
//        }
//
//        return view;
//    }
//
//
//    //bundle for both partial and fullscreen maps
//    private Bundle restaurantMapBundle (){
//        if(!restaurantLat.isEmpty() && !restaurantLon.isEmpty()){
//            Bundle bundle = new Bundle();
//            bundle.putString("restaurant_name", "Original Grill");
//            bundle.putString("restaurant_lat", restaurantLat);
//            bundle.putString("restaurant_lon", restaurantLon);
//            return bundle;
//        }
//
//        return null;
//    }
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//
//        inflater.inflate(R.menu.details_view_menu, menu);
//    }


//    Fragment detailsEditFragment = new DetailsEditFragment();
//    private void startDetailsEditFragment(){
//        detailsEditFragment.setArguments(restaurantMapBundle());
//
//
//        getParentFragmentManager().beginTransaction().replace(R.id.fragmentContainer_activity_details, detailsEditFragment).addToBackStack("null").commit();
//
//    }

//
//    private void startAboutActivity(){
//        Intent intent = new Intent(getActivity(), AboutActivity.class);
//        startActivity(intent);
//    }
//
//    private void startMapActivity(){
//        Bundle bundle = restaurantMapBundle();
//        Intent intent = new Intent(getActivity(), MapActivity.class);
//        if (bundle!= null){
//            intent.putExtras(bundle);
//        }
//        startActivity(intent);
//
//    }
//
//
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//
//        int item_id = item.getItemId();
//
//        if (item_id == R.id.menu_details_save){
//            //startDetailsEditFragment();
//
//        }else if (item_id == R.id.menu_details_share){
//            startMapActivity();
//        }
//        else if (item_id == R.id.menu_details_about){
//            startAboutActivity();
//        }
//        else{
//            return super.onOptionsItemSelected(item);
//        }
//        return true;
//    }
//
//}