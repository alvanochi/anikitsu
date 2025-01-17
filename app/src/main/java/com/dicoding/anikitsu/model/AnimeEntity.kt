package com.dicoding.anikitsu.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anime")
data class AnimeEntity(
    @field:ColumnInfo(name = "id")
    @field:PrimaryKey
    val id: String,

    @field:ColumnInfo(name = "titles")
    val titles: String,

    @field:ColumnInfo(name = "posterImage")
    val posterImage: String,

    @field:ColumnInfo(name = "createdAt")
    val createdAt: String
)
