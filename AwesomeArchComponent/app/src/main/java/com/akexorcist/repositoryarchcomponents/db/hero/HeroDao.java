package com.akexorcist.repositoryarchcomponents.db.hero;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.akexorcist.repositoryarchcomponents.api.hero.response.Hero;

import java.util.List;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

@Dao
public interface HeroDao {
    @Query("DELETE FROM hero_info")
    public void clearAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Hero... heroes);

    @Query("SELECT * FROM hero_info")
    LiveData<List<Hero>> queryAll();
}
