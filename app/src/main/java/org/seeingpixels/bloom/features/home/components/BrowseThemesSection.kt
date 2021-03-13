package org.seeingpixels.bloom.features.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.seeingpixels.bloom.features.home.data.DummyPlants

fun LazyListScope.browseThemesSection() {
    item {
        SectionTitle(title = "Browse Themes")
    }
    item {
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            items(DummyPlants) { plant ->
                BrowseThemeItem(plant)
            }
        }
    }
}