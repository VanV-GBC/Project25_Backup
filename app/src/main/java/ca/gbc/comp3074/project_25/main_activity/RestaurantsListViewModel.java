package ca.gbc.comp3074.project_25.main_activity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import ca.gbc.comp3074.project_25._restaurant.Restaurant;
import ca.gbc.comp3074.project_25._restaurant.RestaurantRepository;

public class RestaurantsListViewModel extends AndroidViewModel {

    private final RestaurantRepository repository;
    private final LiveData<List<Restaurant>> allRestaurants;


    public RestaurantsListViewModel(@NonNull Application application) {
        super(application);
        repository = new RestaurantRepository(application);
        allRestaurants = repository.getAllRestaurants();
    }


    public void insert(Restaurant restaurant) {
        repository.insert(restaurant);
    }

    public void update(Restaurant restaurant){
        repository.update(restaurant);
    }

    public void delete(Restaurant restaurant){
        repository.delete(restaurant);
    }

    public void deleteAllRestaurants(){
        repository.deleteAllRestaurants();
    }

    public LiveData<List<Restaurant>> getAllRestaurants(){
        return allRestaurants;
    }


}
