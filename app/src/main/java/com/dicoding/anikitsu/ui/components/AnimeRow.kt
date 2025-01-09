package com.dicoding.anikitsu.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.dicoding.anikitsu.R

@Composable
fun AnimeRow(
    image: Int,
    title: String,
    createdAt: String
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        items(count = 10) {
            AnimeItem(image, title, createdAt)
        }
    }
}