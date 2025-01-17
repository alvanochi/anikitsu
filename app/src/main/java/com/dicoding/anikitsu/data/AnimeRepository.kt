package com.dicoding.anikitsu.data

import com.dicoding.anikitsu.model.Anime
import com.dicoding.anikitsu.model.AnimeEntity
import com.dicoding.anikitsu.model.DetailAnime

interface AnimeRepository {
    suspend fun getListOngoingAnime(): Anime

    suspend fun getListFinishedAnime(): Anime

    suspend fun getListQueryAnime(query: String): Anime

    suspend fun getAnimeById(animeId: String): DetailAnime

    suspend fun getFavAnime(): List<AnimeEntity>

    suspend fun saveAnime(anime: List<AnimeEntity>)

    suspend fun deleteAnime(animeId: String)

    suspend fun isAnimeFavorite(animeId: String): AnimeEntity

}