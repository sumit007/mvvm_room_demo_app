package com.mygate.mygatetest;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Sumit on 13/04/19.
 */


@Entity(tableName = "user_table")
public class User {
    @PrimaryKey(autoGenerate = true) int userId;
    private String userName;
    private String passcode;
    private String imagePath;

    public User() {

    }

    public User(String username, String imagePath) {
        this.imagePath = imagePath;
        this.passcode = PassCodeGenerator.generatePasscode();
        this.userName = username;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasscode() {
        return passcode;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setPasscode(String passcode) {
        this.passcode = passcode;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
