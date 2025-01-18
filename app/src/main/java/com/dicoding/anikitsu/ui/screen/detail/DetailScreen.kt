package com.dicoding.anikitsu.ui.screen.detail

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.dicoding.anikitsu.model.AnimeEntity
import com.dicoding.anikitsu.ui.components.FloatingFavButton
import com.dicoding.anikitsu.ui.components.HeadlineText
import com.dicoding.anikitsu.ui.components.ShimmerDetail
import com.dicoding.anikitsu.ui.components.SubTitleText
import com.dicoding.anikitsu.util.Util

@Composable
fun DetailScreen(
    animeId: String,
    viewModel: DetailViewModel = hiltViewModel()
) {
    viewModel.getAnimeById(animeId)

    LaunchedEffect(animeId) {
        viewModel.isAnimeFavorite(animeId)
    }

    val anime by viewModel.anime.collectAsState()
    val errorState by viewModel.error.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()
    val isFavAnime by viewModel.isFavAnime.collectAsState()

    if (isLoading) {
        ShimmerDetail()
    } else {
        val attributes = anime?.attributes

        val animeEntity = AnimeEntity(
            id = anime?.id ?: "-1",
            titles = attributes?.titles?.en ?: attributes?.titles?.jaJp ?: "No titles",
            posterImage = attributes?.posterImage?.medium ?: "defaultPosterImage",
            createdAt = attributes?.createdAt ?: "Unknown",
        )

        DetailContent(
            id = anime?.id ?: "-1",
            coverImage = attributes?.coverImage?.original ?: "defaultCoverImage",
            posterImage = attributes?.posterImage?.medium ?: "defaultPosterImage",
            title = attributes?.titles?.en ?: attributes?.titles?.jaJp ?: "No titles",
            createdAt = attributes?.createdAt ?: "Unknown",
            subType = attributes?.subtype ?: "Unknown",
            episodeCount = "${attributes?.episodeCount} Episode",
            desc = attributes?.description ?: "No Description",
            onClick = {
                if (isFavAnime != null) {
                    viewModel.deleteAnime(animeId)
                } else {
                    viewModel.saveAnime(listOf(animeEntity))
                }
            },
            isFav = isFavAnime != null
        )
    }
}


@Composable
fun DetailContent(
    id: String,
    coverImage: String,
    posterImage: String,
    title: String,
    createdAt: String,
    subType: String,
    episodeCount: String,
    desc: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isFav: Boolean
) {
    Scaffold(
        floatingActionButton = {
            FloatingFavButton(
                onClick = onClick,
                modifier = modifier
                    .offset(x = (-20).dp),
                isFav = isFav
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Box{
                AsyncImage(
                    model = coverImage,
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth,
                    modifier = modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
                AsyncImage(
                    model = posterImage,
                    contentDescription = null,
                    modifier = modifier
                        .offset(18.dp, 120.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
            }
            HeadlineText(title, modifier = modifier.padding(top = 120.dp, start = 18.dp))
            Row {
                SubTitleText(Util.extractYear(createdAt).toString(), modifier = modifier.padding(start = 20.dp))
                SubTitleText(subType, modifier = modifier.padding(start = 8.dp))
                SubTitleText(episodeCount, modifier = modifier.padding(start = 8.dp))
            }
            SubTitleText(
                desc,
                maxLines = 999,
                modifier = modifier
                    .padding(start = 20.dp, top = 12.dp, end = 16.dp)
            )
        }
    }
}