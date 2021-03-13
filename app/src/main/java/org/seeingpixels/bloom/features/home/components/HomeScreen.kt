package org.seeingpixels.bloom.features.home.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.seeingpixels.bloom.app.components.BloomBottomNavigation

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier,
        bottomBar = {
            BloomBottomNavigation()
        },
        content = { paddingValues ->
            LazyColumn(modifier = Modifier.padding(paddingValues)) {
                stickySearchBar()
                browseThemesSection()
                designYourGardenSection()
            }
        }
    )
}

