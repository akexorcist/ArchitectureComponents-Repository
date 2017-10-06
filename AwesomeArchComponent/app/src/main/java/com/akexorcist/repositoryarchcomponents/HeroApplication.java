package com.akexorcist.repositoryarchcomponents;

import android.app.Application;

import com.akexorcist.repositoryarchcomponents.db.DatabaseManager;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

public class HeroApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseManager.init(this);
    }
}
