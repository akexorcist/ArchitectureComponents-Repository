package com.akexorcist.repositoryarchcomponents.hero

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.akexorcist.repositoryarchcomponents.api.hero.respond.Hero

/**
 * Created by aniru on 22-Dec-17.
 */
@Dao
interface HeroDao {

    @Query("DELETE FROM hero_info")
    fun clearAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(heroes: List<Hero>)

    @Query("SELECT * FROM hero_info")
    fun getAll(): LiveData<List<Hero>>

}