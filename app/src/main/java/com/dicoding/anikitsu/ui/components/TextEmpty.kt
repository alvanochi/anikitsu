package com.dicoding.anikitsu.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TextEmpty(
    text: String,
    modifier: Modifier = Modifier
    ) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            modifier = modifier
                .align(Alignment.Center)
                .padding(horizontal = 16.dp, vertical = 200.dp)
        )
    }
}
