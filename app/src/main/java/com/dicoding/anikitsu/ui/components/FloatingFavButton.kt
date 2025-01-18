package com.dicoding.anikitsu.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.dicoding.anikitsu.R

@Composable
fun FloatingFavButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isFav: Boolean
) {
    FilledIconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        if(isFav) {
            Icon(
                imageVector = Icons.Filled.Favorite,
                contentDescription = stringResource(R.string.menu_favorite),
            )
        } else {
            Icon(
                imageVector = Icons.Filled.FavoriteBorder,
                contentDescription = stringResource(R.string.menu_favorite),
            )
        }
    }
}