package com.chungha.feature_search

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.produceState
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
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.example.core_designsystem.theme.*

@Composable
fun SearchRoute(
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    SearchScreen(searchViewModel = searchViewModel)
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    searchViewModel: SearchViewModel,
    modifier: Modifier = Modifier
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
                    end = parent.end
                )
                top.linkTo(parent.top, 6.0.dp)
            }
        ) { queryInput ->
            searchViewModel.queryTextChange(queryInput)
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
                text = "Search Movie ...",
                style = TextFieldStyle
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = PurpleGray30,
            textColor = TextFieldTextColor,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardActions = KeyboardActions(
            onSearch = {
                focusManager.clearFocus()
                keyboardController?.hide()
            }
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Search,
            keyboardType = KeyboardType.Text
        ),
        shape = MaterialTheme.shapes.small,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search",
                tint = TextFieldTextColor
            )
        },
        modifier = modifier
            .clip(RoundedShape)

    )
}