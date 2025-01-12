package com.dicoding.anikitsu.ui.screen.detail

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.dicoding.anikitsu.ui.components.HeadlineText
import com.dicoding.anikitsu.ui.components.ShimmerDetail
import com.dicoding.anikitsu.ui.components.SubTitleText

@Composable
fun DetailScreen(
    animeId: String,
    viewModel: DetailViewModel = hiltViewModel(),
){
    viewModel.getAnimeById(animeId)


    val anime by viewModel.anime.collectAsState()
    val errorState by viewModel.error.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()


    if (isLoading) {
        ShimmerDetail()
    } else {
        val attributes = anime?.attributes
        DetailContent(
            coverImage = attributes?.coverImage?.original ?: "defaultCoverImage",  // Nilai default jika null
            posterImage = attributes?.posterImage?.medium ?: "defaultPosterImage",  // Nilai default jika null
            title = attributes?.titles?.en ?: attributes?.titles?.jaJp ?: "No titles",  // Judul default jika null
            createdAt = attributes?.createdAt ?: "Unknown",  // Tanggal default jika null
            subType = attributes?.subtype ?: "Unknown",  // Subtype default jika null
            episodeCount = "${attributes?.episodeCount} Episode",  // Subtype default jika null
            desc = attributes?.description ?: "No Description",  // Deskripsi default jika null
        )
    }



}

@Composable
fun DetailContent(
    coverImage: String,
    posterImage: String,
    title: String,
    createdAt: String,
    subType: String,
    episodeCount: String,
    desc: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
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
            SubTitleText(createdAt, modifier = modifier.padding(start = 20.dp))
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