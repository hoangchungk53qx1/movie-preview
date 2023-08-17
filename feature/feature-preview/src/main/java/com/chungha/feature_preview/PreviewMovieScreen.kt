package com.chungha.feature_preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PreviewMovieRoute(
    previewViewModel: PreviewViewModel = hiltViewModel()
) {
    PreviewScreen(previewViewModel = previewViewModel)
}

@Composable
fun PreviewScreen(
    previewViewModel: PreviewViewModel,
    modifier: Modifier = Modifier,
) {
    PreviewContent(

    )
}

@Composable
fun PreviewContent() {

}
