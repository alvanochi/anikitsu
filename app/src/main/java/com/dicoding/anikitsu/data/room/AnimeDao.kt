package com.dicoding.anikitsu.data.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dicoding.anikitsu.model.AnimeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {
    @Query("SELECT * FROM anime")
    suspend fun getFavAnime(): List<AnimeEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun saveAnime(anime: List<AnimeEntity>)

    @Query("DELETE FROM anime WHERE id = :animeId")
    suspend fun deleteAnime(animeId: String)

    @Query("SELECT EXISTS(SELECT * FROM anime WHERE id = :animeId)")
    fun isAnimeFavorite(animeId: String): Flow<Boolean>
}