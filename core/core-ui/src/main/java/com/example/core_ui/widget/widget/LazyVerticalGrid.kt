package com.example.core_ui.widget.widget

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.chungha.core_domain.model.MovieModel
import kotlinx.collections.immutable.ImmutableList


@Composable
fun LazyVerticalGridMovie(
    listMovie: ImmutableList<MovieModel>,
    modifier: Modifier = Modifier,
    state: LazyGridState = rememberLazyGridState(),
    contentPadding: PaddingValues = PaddingValues(vertical = 3.0.dp),
    itemClicked: (movieIndex: Int) -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(count = 2),
        modifier = modifier.padding(horizontal = 3.0.dp),
        contentPadding = contentPadding,
        state = state
    ) {
        items(listMovie) { movieItem ->
            MoviePreviewCell(movieModel = movieItem) {
                itemClicked(it)
            }
        }
    }
}

