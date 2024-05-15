package com.example.core_ui.widget.widget

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.chungha.movie_preview.core.ui.R
import com.example.core_designsystem.theme.RoundedShape

@Composable
fun MoviePoster(
    imagePath: String,
    modifier: Modifier = Modifier
) {
    Card(
        shape = RoundedShape,
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(imagePath).crossfade(false)
                .build(),
            contentDescription = "moviePoster",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            placeholder = painterResource(id = R.drawable.placeholder)
        )
    }
}

@Composable
@Preview(name = "MoviePoster", showBackground = true)
fun MoviePosterPreview() {
    MoviePoster("")
}