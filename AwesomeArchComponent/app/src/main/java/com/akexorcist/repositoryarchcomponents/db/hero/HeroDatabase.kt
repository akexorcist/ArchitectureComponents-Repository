package com.akexorcist.repositoryarchcomponents.hero

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.akexorcist.repositoryarchcomponents.api.hero.respond.Hero
import com.akexorcist.repositoryarchcomponents.api.hero.respond.VoteResult

/**
 * Created by Anirut Teerabut on 12/23/2017.
 */
@Database(entities = arrayOf(Hero::class, VoteResult::class), version = 1)
abstract class HeroDatabase : RoomDatabase() {

    abstract fun heroDao(): HeroDao

    abstract fun voteDao(): VoteDao
}