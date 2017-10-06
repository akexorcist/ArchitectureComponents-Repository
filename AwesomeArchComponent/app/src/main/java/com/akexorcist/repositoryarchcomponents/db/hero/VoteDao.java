package com.akexorcist.repositoryarchcomponents.db.hero;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.akexorcist.repositoryarchcomponents.api.hero.response.VoteResult;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

@Dao
public interface VoteDao {
    @Query("DELETE FROM vote_result")
    public void clear();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(VoteResult result);

    @Query("SELECT * FROM vote_result LIMIT 1")
    LiveData<VoteResult> query();
}
