package org.seeingpixels.bloom.features.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage
import org.seeingpixels.bloom.features.home.data.Plant
import org.seeingpixels.bloom.theme.MaterialShape
import org.seeingpixels.bloom.theme.MaterialTypography

@Composable
fun BrowseThemeItem(
    plant: Plant,
    modifier: Modifier = Modifier,
    onPlantClick: () -> Unit = {}
) {
    Card(
        shape = MaterialShape.small,
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onPlantClick)
    ) {
        Column {
            CoilImage(
                data = plant.imageUrl,
                contentScale = ContentScale.Crop,
                contentDescription = plant.name,
                modifier = modifier.size(136.dp)
            )
            Text(
                text = plant.name,
                style = MaterialTypography.h2,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}