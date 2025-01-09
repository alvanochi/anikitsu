package com.dicoding.anikitsu.ui.screen.favorite

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dicoding.anikitsu.R

@Composable
fun FavoriteScreen(
    modifier: Modifier = Modifier
) {
    Text(stringResource(R.string.menu_favorite))
}