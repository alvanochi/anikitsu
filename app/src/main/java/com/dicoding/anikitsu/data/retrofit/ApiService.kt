package com.dicoding.anikitsu.data.retrofit

import com.dicoding.anikitsu.model.Anime
import com.dicoding.anikitsu.model.DataItem
import com.dicoding.anikitsu.model.DetailAnime
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("anime")
    suspend fun getOngoingAnime(
        @Query("page[limit]") limit: String = "10",
        @Query("filter[status]") status: String = "current"
    ): Anime

    @GET("anime")
    suspend fun getFinishedAnime(
        @Query("page[limit]") limit: String = "10",
        @Query("filter[status]") status: String = "finished"
    ): Anime

    @GET("anime")
    suspend fun getQueryAnime(
        @Query("filter[text]") query: String? = null,
        @Query("page[limit]") limit: String = "20"
    ): Anime

    @GET("anime/{animeId}")
    suspend fun getAnimeById(
        @Path("animeId") animeId: String
    ): DetailAnime
}