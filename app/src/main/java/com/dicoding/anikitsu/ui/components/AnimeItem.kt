package com.dicoding.anikitsu.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

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
                .padding(top = 4.dp, start = 4.dp, end = 4.dp)
                .width(160.dp)
        )
        Text(
            createdAt,
            style = MaterialTheme.typography.titleSmall,
            modifier = modifier.padding(horizontal = 4.dp)
            )
    }
}