package com.dicoding.anikitsu.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Bookmark : Screen("bookmark")
    object Profile : Screen("profile")
//    object DetailAnime : Screen("home/{animeId}") {
//        fun createRoute(rewardId: Long) = "home/$animeId"
//    }
}