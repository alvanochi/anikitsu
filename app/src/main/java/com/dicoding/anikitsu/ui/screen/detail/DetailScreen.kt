package com.dicoding.anikitsu.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.anikitsu.R
import com.dicoding.anikitsu.ui.components.HeadlineText
import com.dicoding.anikitsu.ui.components.SubTitleText
import com.dicoding.anikitsu.ui.theme.AniKitsuTheme

@Composable
fun DetailScreen(
    animeId: Long,
//    viewModel: DetailViewModel = viewModel(
//        factory = ViewModelFactory(
//            Injection.provideRepository()
//        )
//    ),
    navigateBack: () -> Unit,
) {
//    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
//        when (uiState) {
//            is UiState.Loading -> {
//                viewModel.getById(animeId)
//            }
//            is UiState.Success -> {
//                val data = uiState.data
//                DetailContent(
//                    data.reward.image,
//                    data.reward.title,
//                    data.reward.requiredPoint,
//                    data.count,
//                    onBackClick = navigateBack,
//                    onAddToCart = { count ->
//                        viewModel.addToCart(data.reward, count)
//                        navigateToCart()
//                    }
//                )
//            }
//            is UiState.Error -> {}
//        }
//    }
}

@Composable
fun DetailContent(
    coverImage: Int,
    image: Int,
    title: String,
    createdAt: String,
    subType: String,
    desc: String,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {
        Box{
            Image(
                painter = painterResource(coverImage),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
                modifier = modifier.fillMaxWidth()
            )
            Image(
                painter = painterResource(image),
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
        }
        SubTitleText(
            desc,
            maxLines = 10,
            modifier = modifier
                .padding(start = 20.dp, top = 12.dp, end = 16.dp)
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL, showSystemUi = true)
@Composable
fun PreviewDetail() {
    AniKitsuTheme {
        DetailContent(
            R.drawable.cover,
            R.drawable.conan,
            "Conan",
            "2024",
            "TV",
            stringResource(R.string.anime_desc)
        )
    }
}