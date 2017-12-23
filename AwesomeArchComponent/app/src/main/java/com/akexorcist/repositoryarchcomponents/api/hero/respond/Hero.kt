package com.akexorcist.repositoryarchcomponents.api.hero.respond

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by aniru on 22-Dec-17.
 */
@Entity(tableName = "hero_info")
data class Hero (
        @PrimaryKey
        var id: String,
        var name: String,
        var alias: String,
        var type: String,
        var url: String
)