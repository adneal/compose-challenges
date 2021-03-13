package org.seeingpixels.bloom.features.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.seeingpixels.bloom.common.modifier.baselineHeight
import org.seeingpixels.bloom.theme.MaterialColors
import org.seeingpixels.bloom.theme.MaterialTypography

@Composable
fun SectionTitle(
    title: String,
    icon: ImageVector? = null,
    iconButtonContentDescription: String? = null,
    onIconClick: (() -> Unit)? = null
) {
    Row(
        modifier = Modifier
            .baselineHeight(if (icon != null) 40.dp else 32.dp)
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTypography.h1
        )
        if (icon != null) IconButton(
            onClick = { if (onIconClick != null) onIconClick() },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
        ) {
            Image(
                imageVector = icon,
                contentDescription = iconButtonContentDescription,
                colorFilter = ColorFilter.tint(MaterialColors.onBackground),
                modifier = Modifier.size(24.dp)
            )
        }
    }
}