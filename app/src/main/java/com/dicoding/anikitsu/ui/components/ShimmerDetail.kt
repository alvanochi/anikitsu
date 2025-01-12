package com.dicoding.anikitsu.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.anikitsu.ui.theme.AniKitsuTheme

@Composable
fun ShimmerDetail(
    modifier: Modifier = Modifier
) {
    Column {
        Box (
            modifier = modifier
                .fillMaxWidth()
                .height(200.dp)
                .shimmerEffect()
        )
        Box(
            modifier = modifier
                .offset(18.dp, (-80).dp)
                .size(120.dp, 200.dp)
                .clip(RoundedCornerShape(20.dp))
                .shimmerEffect()
        )
        Spacer(modifier = modifier.height(16.dp))
        Column(
            modifier = modifier
            .offset(18.dp, (-80).dp)
        ) {
            Box(
                modifier = modifier
                    .size(200.dp, 16.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .shimmerEffect()
            )
            Spacer(modifier = modifier.height(8.dp))
            Box(
                modifier = modifier
                    .size(300.dp, 12.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .shimmerEffect()
            )
            Box(
                modifier = modifier
                    .padding(top = 4.dp)
                    .size(300.dp, 12.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .shimmerEffect()
            )
            Box(
                modifier = modifier
                    .padding(top = 4.dp)
                    .size(300.dp, 12.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .shimmerEffect()
            )
            Box(
                modifier = modifier
                    .padding(top = 4.dp)
                    .size(300.dp, 12.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .shimmerEffect()
            )
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4_XL, showSystemUi = true)
@Composable
fun PreviewDetail() {
    AniKitsuTheme {
        ShimmerDetail()
    }
}