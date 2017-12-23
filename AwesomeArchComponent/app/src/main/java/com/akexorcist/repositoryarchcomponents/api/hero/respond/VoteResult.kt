package com.akexorcist.repositoryarchcomponents.api.hero.respond

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by aniru on 22-Dec-17.
 */
@Entity(tableName = "vote_result")
data class VoteResult(
        @PrimaryKey
        var status: String,
        var message: String
)