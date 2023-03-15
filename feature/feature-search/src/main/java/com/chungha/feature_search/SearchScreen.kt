package com.chungha.feature_search

import android.util.Log
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
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalLifecycleOwner
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
import com.chungha.core_domain.model.MovieModel
import com.example.core_designsystem.theme.*
import com.example.core_ui.widget.widget.LoadingPreview
import com.example.core_ui.widget.common.LceState
import com.example.core_ui.widget.common.getValueLceOrNull
import com.example.core_ui.widget.common.showLoadingLceState
import com.example.core_ui.widget.widget.LazyVerticalGridMovie
import kotlinx.collections.immutable.toImmutableList

@Composable
fun SearchRoute(
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    SearchScreen(searchViewModel = searchViewModel)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel, modifier: Modifier = Modifier
) {
    val lifecycle = LocalLifecycleOwner.current.lifecycle
    val keyboardController = LocalSoftwareKeyboardController.current
    val queryValue: String by searchViewModel.query.observeAsState(initial = "")
    val uiState by searchViewModel.uiState.collectAsStateWithLifecycle()
    ConstraintLayout(modifier = modifier.fillMaxSize()) {
        val (query, content) = createRefs()
        SearchTextField(
            queryValue = queryValue,
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
            searchViewModel.queryTextChange(queryInput)
        }
        SearchContent(uiState = uiState,
            queryValue = queryValue,
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

        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchTextField(
    queryValue: String,
    keyboardController: SoftwareKeyboardController?,
    modifier: Modifier = Modifier,
    onValueChange: (String) -> Unit
) {
    val focusManager = LocalFocusManager.current
    TextField(
        value = queryValue,
        onValueChange = onValueChange,
        singleLine = true,
        maxLines = 1,
        textStyle = TextFieldStyle,
        placeholder = {
            Text(
                text = "Search Movie ...", style = TextFieldStyle
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = PurpleGray30,
            textColor = TextFieldTextColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardActions = KeyboardActions(onSearch = {
            focusManager.clearFocus()
            keyboardController?.hide()
        }),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search, keyboardType = KeyboardType.Text
        ),
        shape = MaterialTheme.shapes.small,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = TextFieldTextColor
            )
        },
        modifier = modifier.clip(RoundedShape)

    )
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchContent(
    uiState: LceState<List<MovieModel>>,
    queryValue: String,
    keyboardController: SoftwareKeyboardController?,
    modifier: Modifier = Modifier,
    onItemMovieClick: (Int) -> Unit
) {
    ConstraintLayout(modifier = modifier) {
        val (loading, listMovieRef, noResult) = createRefs()
        if (showLoadingLceState(uiState) && queryValue.isNotEmpty()) {
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
            val movieResult = getValueLceOrNull(uiState)
            val state = rememberLazyGridState()
            val scroll = remember { derivedStateOf { state.firstVisibleItemScrollOffset } }
            if (scroll.value > 0) {
                keyboardController?.hide()
            }
            if (movieResult.isNullOrEmpty()) {
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
                    listMovie = movieResult.toImmutableList(),
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

                }
            }
        }
    }
}