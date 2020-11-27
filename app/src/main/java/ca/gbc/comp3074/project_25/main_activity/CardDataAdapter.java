package ca.gbc.comp3074.project_25.main_activity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;
import java.util.List;

import ca.gbc.comp3074.project_25.R;
import ca.gbc.comp3074.project_25._restaurant.Restaurant;

public class CardDataAdapter extends RecyclerView.Adapter<CardDataAdapter.CardHolder> {

    private List<Restaurant> restaurants = new ArrayList<>();

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.restaurant_item,parent,false);
        return new CardHolder(itemView);
    }

    private int restaurantId;
    private String restaurantName;
    private Float restaurantRating;
    private ChipGroup restaurantTags;


//
//    private String restaurantName;
//    private String restaurantAddyLine1;
//    private String restaurantAddyLine2;
//    private String restaurantCity;
//    private String restaurantPostalCode;
//
//    private String restaurantProvince;
//    private String restaurantCountry;
//    private String restaurantPhoneNumber;
//    private String restaurantEmail;
//    private String restaurantWebsite;
//    private String restaurantDescription;
//    private Double restaurantLat;
//    private Double restaurantLon;
//    private Float restaurantRating;
//    private String restaurantTags;

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        Restaurant currentRestaurant = restaurants.get(position);
        holder.txtRestaurantName.setText(currentRestaurant.getRestaurantName());
//        holder.txtRestaurantName.setText(currentRestaurant.getRestaurantAddyLine1());
//        holder.txtRestaurantName.setText(currentRestaurant.getRestaurantAddyLine2());
//        holder.txtRestaurantName.setText(currentRestaurant.getRestaurantCity());
//        holder.txtRestaurantName.setText(currentRestaurant.getRestaurantPostalCode());
//        holder.txtRestaurantName.setText(currentRestaurant.getRestaurantProvince());
//        holder.txtRestaurantName.setText(currentRestaurant.getRestaurantCountry());
//        holder.txtRestaurantName.setText(currentRestaurant.getRestaurantPhoneNumber());
//        holder.txtRestaurantName.setText(currentRestaurant.getRestaurantEmail());
//        holder.txtRestaurantName.setText(currentRestaurant.getRestaurantWebsite());
//        holder.txtRestaurantName.setText(currentRestaurant.getRestaurantDescription());
//        holder.txtRestaurantName.setText(String.valueOf(currentRestaurant.getRestaurantLat()));
//        holder.txtRestaurantName.setText(String.valueOf(currentRestaurant.getRestaurantLon()));
        holder.txtRestaurantRating.setRating(currentRestaurant.getRestaurantRating());

        Context context = holder.itemChipGroup.getContext();
        List<String> tags = currentRestaurant.getRestaurantTags();
        ChipGroup restaurantTags = new ChipGroup(context);
        for (String tag : tags){
            Chip chip = new Chip(context);
            chip.setText(tag);
            //restaurantTags.addView(chip);
            holder.itemChipGroup.addView(chip); // IT WORKS!!!!
        }


    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public void setRestaurants(List<Restaurant> restaurants){
        this.restaurants = restaurants;
        notifyDataSetChanged();
    }


    class CardHolder extends RecyclerView.ViewHolder {
        private TextView txtRestaurantName;
        private RatingBar txtRestaurantRating;
        private ChipGroup itemChipGroup;

        public CardHolder(View itemView) {
            super(itemView);
            txtRestaurantName = itemView.findViewById(R.id.txt_items_card_restaurant_name);
            txtRestaurantRating = itemView.findViewById(R.id.view_ratingBar_restaurant_rating);
            itemChipGroup = itemView.findViewById(R.id.restaurant_tags);
        }
    }
}
