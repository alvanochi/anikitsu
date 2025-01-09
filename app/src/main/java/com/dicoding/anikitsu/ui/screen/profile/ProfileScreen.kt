package com.dicoding.anikitsu.ui.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.anikitsu.R
import com.dicoding.anikitsu.ui.components.HeadlineText
import com.dicoding.anikitsu.ui.theme.AniKitsuTheme

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            contentDescription = "Photo developer",
            painter = painterResource(R.drawable.alvano),
            modifier = modifier
                .clip(CircleShape)
                .size(180.dp)
        )
        HeadlineText(
            stringResource(R.string.profile_name),
             modifier = modifier.padding(top = 12.dp, bottom = 8.dp)
            )
        Text(
            stringResource(R.string.profile_email)
        )
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL, showSystemUi = true)
@Composable
fun PreviewProfile(){
    AniKitsuTheme {
        ProfileScreen()
    }
}