package com.mygate.mygatetest;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Sumit on 13/04/19.
 */


@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class Userdatabase extends RoomDatabase {

    private static final String TAG = Userdatabase.class.getSimpleName();
    private static final String DATABASE_NAME = "user_db";


    // For Singleton instantiation
    private static final Object LOCK = new Object();

    private static Userdatabase sInstance;

    public static Userdatabase getInstance(Context context) {

        if (sInstance == null) {
            synchronized (LOCK) {
                sInstance = Room.databaseBuilder(context.getApplicationContext(),
                        Userdatabase.class, Userdatabase.DATABASE_NAME).fallbackToDestructiveMigration().build();

            }
        }
        return sInstance;
    }

    // The associated DAOs for the database
    public abstract UserDao getuserDao();

}
