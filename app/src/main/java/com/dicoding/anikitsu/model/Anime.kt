package com.dicoding.anikitsu.model

import com.google.gson.annotations.SerializedName


data class Anime(
    @field:SerializedName("data")
    val data: List<DataItem?>? = null,
)

data class DetailAnime(
    @field:SerializedName("data")
    val data: DataItem? = null,
)

data class DataItem(

    @field:SerializedName("attributes")
    val attributes: Attributes? = null,

    @field:SerializedName("id")
    val id: String? = null,

//    @field:SerializedName("type")
//    val type: String? = null
)

data class Attributes(

//    @field:SerializedName("nextRelease")
//    val nextRelease: Any? = null,

    @field:SerializedName("endDate")
    val endDate: String? = null,

    @field:SerializedName("episodeCount")
    val episodeCount: Int? = null,

    @field:SerializedName("description")
    val description: String? = null,

//    @field:SerializedName("ratingRank")
//    val ratingRank: Int? = null,

    @field:SerializedName("posterImage")
    val posterImage: Image? = null,

    @field:SerializedName("createdAt")
    val createdAt: String? = null,

    @field:SerializedName("subtype")
    val subtype: String? = null,

    @field:SerializedName("coverImage")
    val coverImage: Image? = null,

    @field:SerializedName("titles")
    val titles: Titles? = null,

//    @field:SerializedName("ageRating")
//    val ageRating: String? = null,

//    @field:SerializedName("totalLength")
//    val totalLength: Int? = null,
)

data class Titles(

    @field:SerializedName("en_us")
    val enUs: String? = null,

    @field:SerializedName("en")
    val en: String? = null,

    @field:SerializedName("ja_jp")
    val jaJp: String? = null,

    @field:SerializedName("en_jp")
    val enJp: String? = null
)

data class Image(
    @field:SerializedName("original")
    val original: String? = null,

    @field:SerializedName("medium")
    val medium: String? = null,

    @field:SerializedName("large")
    val large: String? = null,
)