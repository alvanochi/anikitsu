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
import com.dicoding.anikitsu.model.DataItem
import com.dicoding.anikitsu.util.Util


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
            items(animeList, key = { it.id!! }) { dataItem ->
                val attributes = dataItem.attributes
                AnimeItem(
                    image = attributes?.posterImage?.large,
                    title = attributes?.titles?.en ?: attributes?.titles?.enJp ?: attributes?.titles?.jaJp ?: "No titles",
                    createdAt = Util.extractYear("${attributes?.createdAt}").toString(),
                    modifier = Modifier.clickable {
                        navigateToDetail(dataItem.id.orEmpty())
                    }
                )
            }
        }
    }
}