package ca.gbc.comp3074.project_25;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.lang.reflect.Array;

@Entity(tableName = "restaurant_table")
public class Restaurant {

    @PrimaryKey(autoGenerate = true)
    private int restaurantId;

    private String restaurantName;

    private String restaurantAddyLine1;

    private String restaurantAddyLine2;

    private String restaurantCity;

    private String restaurantPostalCode;

    private String restaurantProvince;
    private String restaurantCountry;
    private String restaurantPhoneNumber;
    private String restaurantEmail;
    private Double restaurantLat;
    private Double restaurantLon;
    private Float restaurantRating;
    private String restaurantTags;


    public Restaurant(String restaurantName,
                      String restaurantAddyLine1,
                      String restaurantAddyLine2,
                      String restaurantCity,
                      String restaurantPostalCode,
                      String restaurantProvince,
                      String restaurantCountry,
                      String restaurantPhoneNumber,
                      String restaurantEmail,
                      Double restaurantLat,
                      Double restaurantLon,
                      Float restaurantRating,
                      String restaurantTags) {
        this.restaurantName = restaurantName;
        this.restaurantAddyLine1 = restaurantAddyLine1;
        this.restaurantAddyLine2 = restaurantAddyLine2;
        this.restaurantCity = restaurantCity;
        this.restaurantPostalCode = restaurantPostalCode;
        this.restaurantProvince = restaurantProvince;
        this.restaurantCountry = restaurantCountry;
        this.restaurantPhoneNumber = restaurantPhoneNumber;
        this.restaurantEmail = restaurantEmail;
        this.restaurantLat = restaurantLat;
        this.restaurantLon = restaurantLon;
        this.restaurantRating = restaurantRating;
        this.restaurantTags = restaurantTags;
    }

    // id setter
    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    //getters
    public int getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantAddyLine1() {
        return restaurantAddyLine1;
    }

    public String getRestaurantAddyLine2() {
        return restaurantAddyLine2;
    }

    public String getRestaurantCity() {
        return restaurantCity;
    }

    public String getRestaurantPostalCode() {
        return restaurantPostalCode;
    }

    public String getRestaurantProvince() {
        return restaurantProvince;
    }

    public String getRestaurantCountry() {
        return restaurantCountry;
    }

    public String getRestaurantPhoneNumber() {
        return restaurantPhoneNumber;
    }

    public String getRestaurantEmail() {
        return restaurantEmail;
    }

    public Double getRestaurantLat() {
        return restaurantLat;
    }

    public Double getRestaurantLon() {
        return restaurantLon;
    }

    public Float getRestaurantRating() {
        return restaurantRating;
    }

    public String getRestaurantTags() {
        return restaurantTags;
    }
}
