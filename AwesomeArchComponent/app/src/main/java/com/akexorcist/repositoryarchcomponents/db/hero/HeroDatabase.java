package com.akexorcist.repositoryarchcomponents.db.hero;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.akexorcist.repositoryarchcomponents.api.hero.response.Hero;
import com.akexorcist.repositoryarchcomponents.api.hero.response.VoteResult;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

@Database(entities = {Hero.class, VoteResult.class}, version = 1)
public abstract class HeroDatabase extends RoomDatabase {
    abstract public HeroDao heroDao();

    abstract public VoteDao voteDao();
}
