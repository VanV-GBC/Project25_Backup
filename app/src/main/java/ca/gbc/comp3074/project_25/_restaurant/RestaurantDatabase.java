package ca.gbc.comp3074.project_25._restaurant;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Database(entities = {Restaurant.class}, version =1)
@TypeConverters(Converters.class)
public abstract class RestaurantDatabase extends RoomDatabase {

    // Singleton db
    private static RestaurantDatabase instance;

    //Access DAO
    public abstract RestaurantDao restaurantDao();

    public static synchronized RestaurantDatabase getInstance(Context context){
        // Create single instance of db
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RestaurantDatabase.class, "restaurant_database" )
                    .fallbackToDestructiveMigration() // needed if db changes are made
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private RestaurantDao restaurantDao;

        private PopulateDbAsyncTask(RestaurantDatabase db) {
            restaurantDao = db.restaurantDao();
        }

        List<String> tags = Arrays.asList("Tag1","Tag2","Tag3");
        Date rn = new Date();
        @Override
        protected Void doInBackground(Void... voids){
            restaurantDao.insert(new Restaurant(
                    "Original Grill",
                    "22 Spadina Ave.",
                    "Unit 2",
                    "Toronto",
                    "m4p3f2",
                    "ON",
                    "Canada",
                    "4164390000",
                    "some.place@yahoo.ca",
                    "www.google.com",
                    "4164444444",
                    "This is a nice place. This is also a temporary placeholder/dummy data",
                    43.6723899,
                    -79.4117368,
                    4.5f,
                    tags,
                    rn,
                    rn
            ));

            restaurantDao.insert(new Restaurant(
                    "Original Grill",
                    "22 Spadina Ave.",
                    "Unit 2",
                    "Toronto",
                    "m4p3f2",
                    "ON",
                    "Canada",
                    "4164390000",
                    "some.place@yahoo.ca",
                    "www.google.com",
                    "4164444444",
                    "This is a nice place. This is also a temporary placeholder/dummy data",
                    43.6723899,
                    -79.4117368,
                    4.5f,
                    tags,
                    rn,
                    rn
            ));



            return null;
        }

    }
}
