package com.akexorcist.repositoryarchcomponents.db;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.akexorcist.repositoryarchcomponents.db.hero.HeroDatabase;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

public class DatabaseManager {
    private static HeroDatabase heroDatabase;

    public static void init(Application app) {
        heroDatabase = Room.databaseBuilder(app, HeroDatabase.class, "hero.db").build();
    }

    public static HeroDatabase getHeroDatabase() {
        return heroDatabase;
    }
}
