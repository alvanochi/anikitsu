package com.dicoding.anikitsu.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dicoding.anikitsu.R
import com.dicoding.anikitsu.ViewModelFactory
import com.dicoding.anikitsu.di.Injection
import com.dicoding.anikitsu.ui.common.UiState
import com.dicoding.anikitsu.ui.components.AnimeRow
import com.dicoding.anikitsu.ui.components.HeadlineText
import com.dicoding.anikitsu.ui.components.Search

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    viewModel: HomeViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navigateToDetail: (Long) -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllRewards()
            }
            is UiState.Success -> {
                HomeContent(image = R.drawable.conan, title = "Judul Anime", createdAt = "2024")
            }
            is UiState.Error -> {
                Text("Data tidak ditemukan :(")
            }
        }
    }
}


@Composable
fun HomeContent(
    image: Int,
    title: String,
    createdAt: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Search()

        HeadlineText(stringResource(R.string.section_finished), modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp))
        AnimeRow(image, title, createdAt)

        HeadlineText(stringResource(R.string.section_ongoing), modifier = modifier.padding(vertical = 8.dp, horizontal = 16.dp))
        AnimeRow(image, title, createdAt)
    }
}