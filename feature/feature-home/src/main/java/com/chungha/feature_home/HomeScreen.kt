package com.chungha.feature_home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.chungha.core_domain.model.HomeCategory
import com.chungha.core_domain.model.MovieModel
import com.example.core_designsystem.theme.Background
import com.example.core_designsystem.theme.INDICATOR
import com.example.core_designsystem.theme.MovieTypography
import com.example.core_designsystem.theme.RoundedShape
import com.example.core_ui.widget.widget.MoviePoster
import com.preview.feature.home_feature.R

@Composable
fun HomeRoute(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreen(modifier, homeViewModel)
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel,
) {
    val uiState by homeViewModel.state.collectAsStateWithLifecycle()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Background)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            modifier = Modifier.padding(top = 8.dp, start = 16.dp, end = 16.dp),
            text = stringResource(R.string.what_do_you_want_to_watch),
            style = MovieTypography.titleMedium,
            color = Color.White,
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp)
        ) {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                items(uiState.topRatedMovies) {
                    MoviePoster(
                        imagePath = it.fullMovieImagePath,
                        modifier = Modifier
                            .height(210.dp)
                            .width(145.dp)
                            .clip(RoundedShape)
                            .clickable {
                                // TODO
                            }
                    )
                }
            }
        }

        MovieCategoryTabs(
            modifier = Modifier.padding(top = 24.dp, start = 16.dp),
            categories = uiState.categories,
            selectedCategory = uiState.selectedCategory,
            onCategorySelected = homeViewModel::onCategorySelected,
        )

        LazyVerticalGrid(
            modifier = Modifier.height(640.dp),
            columns = GridCells.Fixed(3),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(24.dp)
        ) {
            podcastCategory(
                movies = uiState.movies,
                navigateToPreview = {
                    // TODO
                }
            )
        }

    }
}

fun LazyGridScope.podcastCategory(
    movies: List<MovieModel>,
    navigateToPreview: (MovieModel) -> Unit,
) {
    items(items = movies) { item ->
        MoviePoster(
            imagePath = item.fullMovieImagePath,
            modifier = Modifier
                .height(162.dp)
                .clip(RoundedShape)
                .clickable {
                    navigateToPreview(item)
                }
        )
    }
}

@Composable
private fun MovieCategoryTabs(
    modifier: Modifier = Modifier,
    categories: List<HomeCategory>,
    selectedCategory: HomeCategory,
    onCategorySelected: (HomeCategory) -> Unit,
) {
    if (categories.isEmpty()) {
        return
    }

    val selectedIndex = categories.indexOf(
        selectedCategory
    )

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        HomeCategoryTabIndicator(
            Modifier.tabIndicatorOffset(tabPositions[selectedIndex])
        )
    }

    ScrollableTabRow(
        edgePadding = 0.dp,
        modifier = modifier,
        selectedTabIndex = selectedIndex,
        containerColor = Color.Transparent,
        divider = {}, /* Disable the built-in divider */
        indicator = indicator,
    ) {
        categories.forEachIndexed { index, category ->
            Tab(
                selected = index == selectedIndex,
                onClick = { onCategorySelected(category) },
                text = {
                    Text(
                        color = Color.White,
                        style = MovieTypography.titleSmall,
                        text = category.value,
                        onTextLayout = { textLayoutResult ->
                            textLayoutResult.size.width // width of the text!
                        }
                    )
                }
            )
        }
    }
}

@Composable
private fun HomeCategoryTabIndicator(
    modifier: Modifier = Modifier,
    color: Color = INDICATOR
) {
    Spacer(
        modifier
            .padding(horizontal = 12.dp)
            .height(4.dp)
            .background(color, RoundedCornerShape(topStartPercent = 100, topEndPercent = 100))
    )
}
