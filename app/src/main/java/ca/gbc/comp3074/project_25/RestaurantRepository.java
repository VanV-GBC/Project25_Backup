package ca.gbc.comp3074.project_25;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;

import java.util.List;

public class RestaurantRepository {
    private RestaurantDao restaurantDao;
    private LiveData<List<Restaurant>> allRestaurants;

    public RestaurantRepository(Application application) {
        RestaurantDatabase database = RestaurantDatabase.getInstance(application);
        restaurantDao = database.restaurantDao();
        allRestaurants = restaurantDao.getAllRestaurants();
    }

    public void insert(Restaurant restaurant){
        new InsertRestaurantAsyncTask(restaurantDao).execute(restaurant);
    }

    public void update(Restaurant restaurant){
        new UpdateRestaurantAsyncTask(restaurantDao).execute(restaurant);

    }

    public void delete(Restaurant restaurant){
        new DeleteRestaurantAsyncTask(restaurantDao).execute(restaurant);
    }


    public void deleteAllRestaurants(Restaurant restaurant){
        new DeleteAllRestaurantsAsyncTask(restaurantDao).execute(restaurant);
    }

    public LiveData<List<Restaurant>> getAllRestaurants() {
        return allRestaurants;
    }

    private static class InsertRestaurantAsyncTask extends AsyncTask<Restaurant,Void,Void> {
        private RestaurantDao restaurantDao;

        private InsertRestaurantAsyncTask(RestaurantDao restaurantDao){
            this.restaurantDao = restaurantDao;
        }

        @Override
        protected  Void doInBackground(Restaurant... restaurants) {
            restaurantDao.insert(restaurants[0]);
            return null;
        }
    }

    private static class UpdateRestaurantAsyncTask extends AsyncTask<Restaurant,Void,Void> {
        private RestaurantDao restaurantDao;

        private UpdateRestaurantAsyncTask(RestaurantDao restaurantDao){
            this.restaurantDao = restaurantDao;
        }

        @Override
        protected  Void doInBackground(Restaurant... restaurants) {
            restaurantDao.update(restaurants[0]);
            return null;
        }
    }

    private static class DeleteRestaurantAsyncTask extends AsyncTask<Restaurant,Void,Void> {
        private RestaurantDao restaurantDao;

        private DeleteRestaurantAsyncTask(RestaurantDao restaurantDao){
            this.restaurantDao = restaurantDao;
        }

        @Override
        protected  Void doInBackground(Restaurant... restaurants) {
            restaurantDao.delete(restaurants[0]);
            return null;
        }
    }

    private static class DeleteAllRestaurantsAsyncTask extends AsyncTask<Restaurant,Void,Void> {
        private RestaurantDao restaurantDao;

        private DeleteAllRestaurantsAsyncTask(RestaurantDao restaurantDao){
            this.restaurantDao = restaurantDao;
        }

        @Override
        protected  Void doInBackground(Restaurant... restaurants) {
            restaurantDao.deleteAllRestaurants();
            return null;
        }
    }

}
