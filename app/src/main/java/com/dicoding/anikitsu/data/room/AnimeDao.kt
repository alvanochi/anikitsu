package com.dicoding.anikitsu.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dicoding.anikitsu.model.AnimeEntity

@Dao
interface AnimeDao {
    @Query("SELECT * FROM anime")
    suspend fun getFavAnime(): List<AnimeEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveAnime(anime: List<AnimeEntity>)

    @Query("DELETE FROM anime WHERE id = :animeId")
    suspend fun deleteAnime(animeId: String)

    @Query("SELECT * FROM anime WHERE id = :animeId")
    suspend fun isAnimeFavorite(animeId: String): AnimeEntity
}