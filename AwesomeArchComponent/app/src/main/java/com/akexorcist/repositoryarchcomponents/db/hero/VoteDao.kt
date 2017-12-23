package com.akexorcist.repositoryarchcomponents.hero

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.akexorcist.repositoryarchcomponents.api.hero.respond.VoteResult

/**
 * Created by Anirut Teerabut on 12/23/2017.
 */
@Dao
interface VoteDao {

    @Query("DELETE FROM vote_result")
    fun clear()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(result: VoteResult)

    @Query("SELECT * FROM vote_result LIMIT 1")
    fun query(): LiveData<VoteResult>
}