package com.dicoding.anikitsu.ui.screen.home

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dicoding.anikitsu.R
import com.dicoding.anikitsu.model.DataItem
import com.dicoding.anikitsu.ui.components.AnimeGrid
import com.dicoding.anikitsu.ui.components.AnimeRow
import com.dicoding.anikitsu.ui.components.HeadlineText
import com.dicoding.anikitsu.ui.components.Search

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navigateToDetail: (String) -> Unit
) {

    val ongoingAnimeList by viewModel.ongoingAnime.collectAsState()
    val finishedAnimeList by viewModel.finishedAnime.collectAsState()
    val queryAnimeList by viewModel.queryAnime.collectAsState()
    val query by viewModel.query
    val errorState by viewModel.error.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(query) {
        viewModel.getListQueryAnime(query)
    }

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ){
        Search(
            query = query,
            onQueryChange = viewModel::getListQueryAnime,
        )
        if(query.isNotEmpty()) {
            HeadlineText(stringResource(R.string.section_query), modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp))
            if(queryAnimeList.isEmpty()){
                Text(
                    text = stringResource(R.string.section_query_empty),
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 200.dp)
                )
            } else {
                HomeQueryContent(queryAnimeList, navigateToDetail, isLoading)
            }
        } else {
            HomeContent(ongoingAnimeList, finishedAnimeList, navigateToDetail, isLoading)
        }
    }
}


@Composable
fun HomeContent(
    ongoingAnime: List<DataItem>,
    finishedAnime: List<DataItem>,
    navigateToDetail: (String) -> Unit,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
) {
    Column {

        HeadlineText(stringResource(R.string.section_finished), modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp))
        AnimeRow(finishedAnime, navigateToDetail, isLoading)

        Spacer(modifier = modifier.padding(12.dp))

        HeadlineText(stringResource(R.string.section_ongoing), modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp))
        AnimeRow(ongoingAnime, navigateToDetail, isLoading)
    }
}


@Composable
fun HomeQueryContent(
    queryAnime: List<DataItem>,
    navigateToDetail: (String) -> Unit,
    isLoading: Boolean,
) {
    Column {
        AnimeGrid(queryAnime, navigateToDetail, isLoading)
    }
}