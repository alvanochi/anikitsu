package com.dicoding.anikitsu.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun TitleText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.titleMedium.copy(
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = modifier.padding(top = 8.dp, bottom = 4.dp)
    )
}