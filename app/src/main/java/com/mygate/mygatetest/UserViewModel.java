package com.mygate.mygatetest;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Sumit on 13/04/19.
 */


public class UserViewModel extends AndroidViewModel {

    private UserDao userDao;
    private ExecutorService executorService;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userDao = Userdatabase.getInstance(application).getuserDao();
        executorService = Executors.newSingleThreadExecutor();
    }

    LiveData<List<User>> getUsers() {
        return userDao.getUsers();
    }

    void saveUser(final User user) {
        executorService.execute(() -> userDao.save(user));
    }

    void deletePost(User post) {
        executorService.execute(() -> userDao.delete(post));
    }
}
