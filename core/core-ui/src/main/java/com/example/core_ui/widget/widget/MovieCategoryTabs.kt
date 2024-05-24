package com.example.core_ui.widget.widget

import androidx.compose.material.Text
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabPosition
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.chungha.core_domain.model.HomeCategory
import com.example.core_designsystem.theme.MovieTypography

@Composable
fun MovieCategoryTabs(
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