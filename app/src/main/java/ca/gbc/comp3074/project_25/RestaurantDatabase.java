package ca.gbc.comp3074.project_25;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.lang.reflect.Array;

@Database(entities = {Restaurant.class}, version =1)
@TypeConverters(Converters.class)
public abstract class RestaurantDatabase extends RoomDatabase {

    private static RestaurantDatabase instance;

    public abstract RestaurantDao restaurantDao();

    public static synchronized RestaurantDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RestaurantDatabase.class, "restaurant_database" )
                    .fallbackToDestructiveMigration()
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

        String tags = "Greek,Gyros,Yum";
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
                    43.6723899,
                    -79.4117368,
                    4.5f, tags
            ));

            restaurantDao.insert(new Restaurant(
                    "Bamboo Buddha",
                    "44 Spadina Ave.",
                    "Unit 5",
                    "Toronto",
                    "y1h1g1",
                    "ON",
                    "Canada",
                    "4164391111",
                    "some.other.place@yahoo.ca",
                    43.6723899,
                    -79.4117368,
                    4.0f, tags
            ));



            return null;
        }

    }
}
