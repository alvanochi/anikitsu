package com.dicoding.anikitsu.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dicoding.anikitsu.model.DataItem

@Composable
fun AnimeRow(
    animeList: List<DataItem>,
    navigateToDetail: (String) -> Unit,
    isLoading: Boolean
) {


    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
    ) {
        if(isLoading) {
            items(5) {
                ShimmerList()
            }
        } else {
            items(animeList) { dataItem ->
                val attributes = dataItem.attributes
                AnimeItem(
                    image = attributes?.posterImage?.large,
                    title = attributes?.titles?.en ?: attributes?.titles?.jaJp ?: "No titles",  // Judul default jika null
                    createdAt = attributes?.createdAt ?: "Unknown",
                    modifier = Modifier.clickable {
                        navigateToDetail(dataItem.id.orEmpty())
                    }
                )
            }
        }
    }
}