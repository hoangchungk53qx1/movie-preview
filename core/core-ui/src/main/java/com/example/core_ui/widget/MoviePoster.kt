package com.example.core_ui.widget

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.chungha.movie_preview.core.ui.R
import com.example.core_designsystem.theme.RoundedShape

@Composable
fun MoviePoster(
    imagePath: String,
    size: Dp,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedShape,
        border = BorderStroke(0.5.dp, Color.Gray),
        modifier = modifier.height(size)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current),
            contentDescription = "moviePoster",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            placeholder = painterResource(id = R.drawable.placeholder)
        )
    }
}