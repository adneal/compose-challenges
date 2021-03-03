/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.seeingpixels.adoptionimpact.features.adoption.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.seeingpixels.adoptionimpact.common.components.Spacing
import org.seeingpixels.adoptionimpact.theme.MaterialColors
import org.seeingpixels.adoptionimpact.theme.MaterialTypography

@Composable
fun IconTextRow(
    icon: ImageVector,
    modifier: Modifier = Modifier,
    iconContentDescription: String? = null,
    text: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.alpha(ContentAlpha.high)
    ) {
        Image(
            imageVector = icon,
            contentDescription = iconContentDescription,
            modifier = Modifier.size(14.dp),
            colorFilter = ColorFilter.tint(color = MaterialColors.onSurface)
        )
        Spacing.TinyHorizontalSpacer()
        Text(
            text = text,
            style = MaterialTypography.subtitle2
        )
    }
}
