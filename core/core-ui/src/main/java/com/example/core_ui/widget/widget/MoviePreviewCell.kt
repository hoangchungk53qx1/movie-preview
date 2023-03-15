package com.example.core_ui.widget.widget

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.chungha.core_domain.model.MovieModel

@Composable
fun MoviePreviewCell(
    movieModel: MovieModel,
    modifier: Modifier = Modifier,
    clickMovie: (Int) -> Unit
) {
    Column(modifier = modifier.padding(vertical = 15.dp, horizontal = 15.dp)) {
        MoviePoster(
            imagePath = movieModel.fullMovieImagePath,
            size = 240.dp,
            modifier = Modifier.clickable {
                clickMovie(movieModel.id)
            })
        Text(
            text = movieModel.originalTitle,
            textAlign = TextAlign.Center,
            color = Color.Blue,
            modifier = Modifier.padding(vertical = 5.dp),
        )
    }
} 