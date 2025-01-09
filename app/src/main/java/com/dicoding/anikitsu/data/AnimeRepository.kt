package com.dicoding.anikitsu.data

import com.dicoding.anikitsu.data.retrofit.ApiService
import com.dicoding.anikitsu.model.Anime
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class AnimeRepository(private val apiService: ApiService) {

    suspend fun getListOngoingAnime(): List<Anime> {
        return apiService.getOngoingAnime()
    }

    companion object {
        @Volatile
        private var instance: AnimeRepository? = null

        fun getInstance(
            apiService: ApiService
        ): AnimeRepository =
            instance ?: synchronized(this) {
                AnimeRepository(apiService).apply {
                    instance = this
                }
            }
    }

}