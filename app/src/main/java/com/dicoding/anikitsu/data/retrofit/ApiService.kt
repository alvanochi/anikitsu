package com.dicoding.anikitsu.data.retrofit

import com.dicoding.anikitsu.model.Anime
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("anime")
    suspend fun getOngoingAnime(
        @Query("page[limit]") limit: String = "10",
        @Query("filter[status]") status: String = "current"
    ): List<Anime>

    @GET
    suspend fun getFinishedAnime(
        @Query("page[limit]") limit: String = "10",
        @Query("filter[status]") status: String = "finished"
    ): List<Anime>
}