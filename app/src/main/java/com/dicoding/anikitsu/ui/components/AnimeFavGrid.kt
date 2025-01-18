package com.dicoding.anikitsu.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dicoding.anikitsu.model.AnimeEntity
import com.dicoding.anikitsu.util.Util

@Composable
fun AnimeFavGrid(
    animeList: List<AnimeEntity>,
    navigateToDetail: (String) -> Unit,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 12.dp),
        modifier = modifier.height(600.dp)
    ) {
        items(animeList) {
            AnimeItem(
                image = it.posterImage,
                title = it.titles,
                createdAt = Util.extractYear(it.createdAt).toString(),
                modifier = Modifier.clickable {
                    navigateToDetail(it.id)
                }
            )
        }
    }
}