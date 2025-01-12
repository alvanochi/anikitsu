package com.dicoding.anikitsu.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.dicoding.anikitsu.R
import com.dicoding.anikitsu.ui.screen.profile.ProfileScreen
import com.dicoding.anikitsu.ui.theme.AniKitsuTheme

@Composable
fun AnimeItem(
    image: String?,
    title: String,
    createdAt: String,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        AsyncImage(
            model = image,
            contentDescription = null,
            modifier = Modifier
                .size(200.dp, 280.dp)
                .clip(RoundedCornerShape(20.dp))
        )
        TitleText(
            title,
            modifier = modifier
                .padding(horizontal = 4.dp)
                .width(160.dp)
        )
        Text(
            createdAt,
            style = MaterialTheme.typography.titleSmall,
            modifier = modifier.padding(horizontal = 4.dp)
            )
    }
}