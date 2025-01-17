package com.dicoding.anikitsu.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dicoding.anikitsu.model.AnimeEntity

@Database(entities = [AnimeEntity::class], version = 1, exportSchema = false)
abstract class AnimeDatabase: RoomDatabase() {
    abstract fun animeDao(): AnimeDao

}