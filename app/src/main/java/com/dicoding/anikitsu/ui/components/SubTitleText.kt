package com.dicoding.anikitsu.ui.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun SubTitleText(
    text: String,
    modifier: Modifier = Modifier,
    maxLines: Int = 1
) {
    Text(
        text,
        maxLines = maxLines,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.titleSmall,
        modifier = modifier
    )
}