package com.chungha.feature_preview

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
//    val uiDetailState = previewViewModel.addCloseable()
    LaunchedEffect(key1 = Unit, block = {

    })

    PreviewContent(

    )
}

@Composable
fun PreviewContent() {

}
