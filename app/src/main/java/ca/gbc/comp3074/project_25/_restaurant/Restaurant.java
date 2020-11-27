package ca.gbc.comp3074.project_25._restaurant;


import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;
import java.util.List;

@Entity(tableName = "restaurant_table")
@TypeConverters({Converters.class})
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
    private String restaurantWebsite;
    private String restaurantSms;
    private String restaurantDescription;
    private Double restaurantLat;
    private Double restaurantLon;
    private Float restaurantRating;
    private List<String> restaurantTags;
    private Date dateTimeCreated;
    private Date dateTimeEdited;

    public Restaurant(String restaurantName,
                      String restaurantAddyLine1,
                      String restaurantAddyLine2,
                      String restaurantCity,
                      String restaurantPostalCode,
                      String restaurantProvince,
                      String restaurantCountry,
                      String restaurantPhoneNumber,
                      String restaurantEmail,
                      String restaurantWebsite,
                      String restaurantSms,
                      String restaurantDescription,
                      Double restaurantLat,
                      Double restaurantLon,
                      Float restaurantRating,
                      List<String> restaurantTags,
                      Date dateTimeCreated,
                      Date dateTimeEdited) {
        this.restaurantName = restaurantName;
        this.restaurantAddyLine1 = restaurantAddyLine1;
        this.restaurantAddyLine2 = restaurantAddyLine2;
        this.restaurantCity = restaurantCity;
        this.restaurantPostalCode = restaurantPostalCode;
        this.restaurantProvince = restaurantProvince;
        this.restaurantCountry = restaurantCountry;
        this.restaurantPhoneNumber = restaurantPhoneNumber;
        this.restaurantEmail = restaurantEmail;
        this.restaurantWebsite = restaurantWebsite;
        this.restaurantSms = restaurantSms;
        this.restaurantDescription = restaurantDescription;
        this.restaurantLat = restaurantLat;
        this.restaurantLon = restaurantLon;
        this.restaurantRating = restaurantRating;
        this.restaurantTags = restaurantTags;
        this.dateTimeCreated = dateTimeCreated;
        this.dateTimeEdited = dateTimeEdited;
    }


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

    public String getRestaurantWebsite() {
        return restaurantWebsite;
    }

    public String getRestaurantSms() { return restaurantSms; }


    public String getRestaurantDescription() {
        return restaurantDescription;
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

    public List<String> getRestaurantTags() {
        return restaurantTags;
    }

    public Date getDateTimeCreated() { return dateTimeCreated;}

    public Date getDateTimeEdited() {return dateTimeEdited; }
}
