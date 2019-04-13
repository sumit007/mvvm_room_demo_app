package com.mygate.mygatetest;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Sumit on 13/04/19.
 */

@Dao
public interface UserDao {
    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getUsers();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveAll(List<User> users);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void save(User user);

    @Update
    void update(User user);

    @Delete
    void delete(User post);
}
