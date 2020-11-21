package ca.gbc.comp3074.project_25;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;

@Dao
public interface RestaurantDao {
    @Insert
    void insert(Restaurant restaurant);

    @Update
    void update(Restaurant restaurant);

    @Delete
    void delete(Restaurant restaurant);

    @Query("DELETE FROM restaurant_table")
    void deleteAllRestaurants();

    @Query("Select * FROM restaurant_table ORDER BY restaurantId DESC")
    LiveData<List<Restaurant>> getAllRestaurants();
}
