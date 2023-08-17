package com.chungha.feature_search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chungha.feature_search.reduxsearch.MovieSearchState
import com.chungha.feature_search.reduxsearch.SearchAction
import com.chungha.feature_search.reduxsearch.SearchReduxViewModel
import com.example.core_designsystem.theme.*
import com.example.core_ui.widget.widget.LoadingPreview
import com.example.core_ui.widget.widget.LazyVerticalGridMovie

@Composable
fun SearchRoute(
    searchViewModel: SearchReduxViewModel = hiltViewModel(),
    navigateToPreview: (idMovie: Int) -> Unit
) {
    SearchScreen(
        searchViewModel = searchViewModel,
        navigateToPreview = navigateToPreview
    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    searchViewModel: SearchReduxViewModel,
    modifier: Modifier = Modifier,
    navigateToPreview: (idMovie: Int) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val uiState by searchViewModel.stateFlow.collectAsStateWithLifecycle()

    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (query, content) = createRefs()
        SearchTextField(
            keyboardController = keyboardController,
            modifier = Modifier.constrainAs(query) {
                linkTo(
                    start = parent.start,
                    end = parent.end,
                    startMargin = 12.0.dp,
                    endMargin = 12.0.dp
                )
                top.linkTo(parent.top, 6.0.dp)
                width = Dimension.fillToConstraints
            },
        ) { queryInput ->
            searchViewModel.dispatch(SearchAction.Search(term = queryInput))
        }
        SearchContent(uiState = uiState,
            keyboardController = keyboardController,
            modifier = Modifier.constrainAs(content) {
                linkTo(
                    start = parent.start, end = parent.end
                )
                linkTo(
                    top = query.bottom, topMargin = 10.dp, bottom = parent.bottom
                )
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            }) {
            navigateToPreview.invoke(it)
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchTextField(
    keyboardController: SoftwareKeyboardController?,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    var queryValue: String by rememberSaveable { mutableStateOf("") }
    TextField(value = queryValue, onValueChange = {
        onValueChange.invoke(it)
        queryValue = it
    }, singleLine = true, maxLines = 1, textStyle = TextFieldStyle, placeholder = {
        Text(
            text = "Search Movie ...", style = TextFieldStyle
        )
    }, colors = TextFieldDefaults.textFieldColors(
        backgroundColor = PurpleGray30,
        textColor = TextFieldTextColor,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    ), keyboardActions = KeyboardActions(onSearch = {
        focusManager.clearFocus()
        keyboardController?.hide()
    }), keyboardOptions = KeyboardOptions(
        imeAction = ImeAction.Search, keyboardType = KeyboardType.Text
    ), shape = MaterialTheme.shapes.small, leadingIcon = {
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search",
            tint = TextFieldTextColor
        )
    }, modifier = modifier.clip(RoundedShape)

    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchContent(
    uiState: MovieSearchState,
    keyboardController: SoftwareKeyboardController?,
    modifier: Modifier = Modifier,
    onItemMovieClick: (Int) -> Unit
) {
    ConstraintLayout(modifier = modifier) {
        val (loading, listMovieRef, noResult) = createRefs()
        if (uiState.isLoading) {
            LoadingPreview(modifier = Modifier.constrainAs(loading) {
                linkTo(
                    start = parent.start, end = parent.end
                )
                linkTo(
                    top = parent.top, bottom = parent.bottom
                )
                width = Dimension.fillToConstraints
                height = Dimension.fillToConstraints
            })
        } else {
            val movieResult = uiState.item
            val state = rememberLazyGridState()
            val scroll = remember { derivedStateOf { state.firstVisibleItemScrollOffset } }
            if (scroll.value > 0) {
                keyboardController?.hide()
            }
            if (movieResult.isEmpty()) {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        color = Color.Blue,
                        style = MovieTypography.bodyMedium,
                        text = "Not Found",
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                LazyVerticalGridMovie(
                    listMovie = movieResult,
                    state = state,
                    contentPadding = PaddingValues(bottom = 12.dp),
                    modifier = Modifier.constrainAs(listMovieRef) {
                        linkTo(
                            start = parent.start, end = parent.end
                        )
                        linkTo(
                            top = parent.top, bottom = parent.bottom
                        )
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    },
                ) {
                    onItemMovieClick.invoke(it)
                }
            }
        }
    }
}