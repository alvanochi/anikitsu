package com.dicoding.anikitsu.data

import com.dicoding.anikitsu.model.Anime
import com.dicoding.anikitsu.model.DataItem
import com.dicoding.anikitsu.model.DetailAnime

interface AnimeRepository {
    suspend fun getListOngoingAnime(): Anime

    suspend fun getListFinishedAnime(): Anime

    suspend fun getListQueryAnime(query: String): Anime

    suspend fun getAnimeById(id: String): DetailAnime
}