package com.mygate.mygatetest;

import android.arch.lifecycle.LiveData;

import java.util.List;

/**
 * Created by Sumit on 13/04/19.
 */


public class UserRepository {

    private static final String TAG = UserRepository.class.getSimpleName();
    private static final Object LOCK = new Object();
    private static UserRepository mUseRepsository;
    private final UserDao mUseDao;

    public UserRepository(UserDao userDao) {
        this.mUseDao = userDao;
    }

    public synchronized static UserRepository getInstance(UserDao userDao) {
        if (mUseRepsository == null) {
            synchronized (LOCK) {
                mUseRepsository = new UserRepository(userDao);
            }
        }
        return mUseRepsository;
    }

    public LiveData<List<User>> getUsers() {
        return mUseDao.getUsers();
    }
}
