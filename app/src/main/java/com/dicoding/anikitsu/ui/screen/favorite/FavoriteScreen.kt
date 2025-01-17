package com.dicoding.anikitsu.ui.screen.favorite

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dicoding.anikitsu.R
import com.dicoding.anikitsu.model.AnimeEntity
import com.dicoding.anikitsu.ui.components.AnimeFavGrid
import com.dicoding.anikitsu.ui.components.HeadlineText
import com.dicoding.anikitsu.ui.components.TextEmpty

@Composable
fun FavoriteScreen(
    viewModel: FavoriteViewModel = hiltViewModel(),
    navigateToDetail: (String) -> Unit,
) {
    viewModel.getListFavAnime()

    val favAnimeList by viewModel.favAnime.collectAsState()

    Column {
        HeadlineText(stringResource(R.string.section_favorite), modifier = Modifier.padding(top = 20.dp, start = 16.dp, bottom = 8.dp))
        if(favAnimeList.isNotEmpty()){
            FavoriteContent(favAnimeList, navigateToDetail)
        } else {
            TextEmpty(stringResource(R.string.section_favorite_empty))
        }
    }

}

@Composable
fun FavoriteContent(
    favAnime: List<AnimeEntity>,
    navigateToDetail: (String) -> Unit,
) {
    AnimeFavGrid(favAnime, navigateToDetail)
}