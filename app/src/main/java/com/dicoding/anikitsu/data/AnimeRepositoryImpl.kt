package com.dicoding.anikitsu.data

import com.dicoding.anikitsu.data.retrofit.ApiService
import com.dicoding.anikitsu.data.room.AnimeDao
import com.dicoding.anikitsu.model.Anime
import com.dicoding.anikitsu.model.AnimeEntity
import com.dicoding.anikitsu.model.DetailAnime
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val animeDao: AnimeDao,
): AnimeRepository {

    override suspend fun getListOngoingAnime(): Anime {
        return apiService.getOngoingAnime()
    }

    override suspend fun getListFinishedAnime(): Anime {
        return apiService.getFinishedAnime()
    }

    override suspend fun getListQueryAnime(query: String): Anime {
        return apiService.getQueryAnime(query)
    }

    override suspend fun getAnimeById(animeId: String): DetailAnime {
        return apiService.getAnimeById(animeId)
    }

    override suspend fun getFavAnime(): List<AnimeEntity> {
        return animeDao.getFavAnime()
    }

    override suspend fun saveAnime(anime: List<AnimeEntity>) {
        return animeDao.saveAnime(anime)
    }

    override suspend fun deleteAnime(animeId: String) {
        return animeDao.deleteAnime(animeId)
    }

}