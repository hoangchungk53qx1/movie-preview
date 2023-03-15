package com.example.core_ui.widget.widget

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.chungha.movie_preview.core.ui.R

@Composable
fun LoadingPreview(modifier: Modifier) {
    val composite by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.amin_loading))
    val processLottie by animateLottieCompositionAsState(
        composition = composite,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition = composite,
        modifier = modifier,
        progress = { processLottie },
    )
}