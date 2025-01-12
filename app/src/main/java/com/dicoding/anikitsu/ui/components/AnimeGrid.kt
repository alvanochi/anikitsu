package com.dicoding.anikitsu.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dicoding.anikitsu.model.DataItem


@Composable
fun AnimeGrid(
    animeList: List<DataItem>,
    navigateToDetail: (String) -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 12.dp),
        modifier = modifier.height(600.dp)
    ) {
        if(isLoading) {
            items(10) {
                ShimmerList()
            }
        } else {
            items(animeList) { dataItem ->
                val attributes = dataItem.attributes
                AnimeItem(
                    image = attributes?.posterImage?.large,
                    title = attributes?.titles?.en ?: attributes?.titles?.jaJp ?: "No titles",
                    createdAt = attributes?.createdAt ?: "Unknown",
                    modifier = Modifier.clickable {
                        navigateToDetail(dataItem.id.orEmpty())
                    }
                )
            }
        }
    }
}