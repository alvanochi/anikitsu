package com.dicoding.anikitsu.data

import android.app.Application
import com.dicoding.anikitsu.data.retrofit.ApiService
import com.dicoding.anikitsu.model.Anime
import com.dicoding.anikitsu.model.DataItem
import com.dicoding.anikitsu.model.DetailAnime
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val appContext: Application
    ): AnimeRepository {

    override suspend fun getListOngoingAnime(): Anime {
        return apiService.getOngoingAnime()
    }

    override suspend fun getListFinishedAnime(): Anime {
        return apiService.getFinishedAnime()
    }

    override suspend fun getAnimeById(id: String): DetailAnime {
        return apiService.getAnimeById(id)
    }


}