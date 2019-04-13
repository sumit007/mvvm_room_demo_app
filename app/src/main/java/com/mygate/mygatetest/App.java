package com.mygate.mygatetest;

import android.app.Application;

/**
 * Created by Sumit on 13/04/19.
 */


public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Userdatabase.getInstance(this); //This will provide AppDatabase Instance
    }
}
