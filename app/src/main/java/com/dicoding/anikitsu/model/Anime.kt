package com.dicoding.anikitsu.model

data class Anime(
    val id: Long,
    val title: String,
    val createdAt: String,
    val desc: String,
    val subType: String,
    val posterImage: String,
    val coverImage: String,
)
