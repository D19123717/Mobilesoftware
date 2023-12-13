package database;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import models.User;
@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDAO getUserDAO();
    private static AppDatabase instance;

    public static AppDatabase getDatabase(final Context context) {
        if (instance == null) {
            synchronized (AppDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context,
                                    AppDatabase.class, "user_database").allowMainThreadQueries()
                            .build();
                }
            }
        }
        return instance;
    }
}
