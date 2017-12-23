package com.akexorcist.repositoryarchcomponents.db

import android.app.Application
import android.arch.persistence.room.Room

import com.akexorcist.repositoryarchcomponents.hero.HeroDatabase


/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

object DatabaseManager {
    var heroDatabase: HeroDatabase? = null
        private set

    fun init(app: Application) {
        heroDatabase = Room.databaseBuilder(app, HeroDatabase::class.java, "hero.db").build()
    }
}
