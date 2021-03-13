package org.seeingpixels.bloom.features.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage
import org.seeingpixels.bloom.features.home.data.Plant
import org.seeingpixels.bloom.theme.MaterialShape
import org.seeingpixels.bloom.theme.MaterialTypography

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun GardenListItem(
    plant: Plant,
    modifier: Modifier = Modifier,
    onPlantClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .padding(start = 16.dp, end = 16.dp)
            .clickable(onClick = onPlantClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        CoilImage(
            data = plant.imageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = plant.name,
            modifier = modifier
                .width(72.dp)
                .clip(MaterialShape.small)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column(modifier = Modifier.weight(weight = 1f)) {
            Column(modifier = Modifier.weight(weight = 1f)) {
                Text(text = plant.name, style = MaterialTypography.h2)
                Text(text = plant.description, style = MaterialTypography.body1)
            }
            Divider()
        }
        Checkbox(
            checked = false,
            onCheckedChange = { /*TODO*/ }
        )
    }
}
