package org.seeingpixels.bloom.features.home.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.seeingpixels.bloom.features.home.data.DummyPlants

fun LazyListScope.designYourGardenSection() {
    item {
        SectionTitle(
            title = "Design your home garden",
            icon = Icons.Rounded.FilterList,
            iconButtonContentDescription = "filter list"
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
    items(DummyPlants) { plant ->
        GardenListItem(plant)
        Spacer(modifier = Modifier.height(8.dp))
    }
}