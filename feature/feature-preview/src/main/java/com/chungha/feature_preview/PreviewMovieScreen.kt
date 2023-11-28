package com.chungha.feature_preview

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chungha.feature_preview.uistate.PreviewUiState

@Composable
fun PreviewMovieRoute(
    previewViewModel: PreviewViewModel = hiltViewModel(),
) {
    PreviewScreen(previewViewModel = previewViewModel)
}

@Composable
fun PreviewScreen(
    previewViewModel: PreviewViewModel,
    modifier: Modifier = Modifier,
) {
    val uiState by previewViewModel.previewUiState.collectAsStateWithLifecycle()

    LaunchedEffect(key1 = Unit, block = {

    })

    PreviewContent(
        uiState = uiState,
        modifier = modifier
    )
}

@Composable
fun PreviewContent(
    uiState: PreviewUiState,
    modifier: Modifier = Modifier,
) {
    when {
        uiState.isLoading -> {
            Log.d("PreviewContent", "uiState Loading: ${uiState.isLoading}")
        }
        uiState.movieContent != null -> {
            Log.d("PreviewContent", "uiState.movieContent: ${uiState.movieContent} and uiState.isLoading: ${uiState.isLoading}")
        }
    }
}
