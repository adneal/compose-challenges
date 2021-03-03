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
package org.seeingpixels.adoptionimpact.common.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Composable
fun Chip(
    text: String,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    selected: Boolean = false,
    borderColor: Color = Color.Unspecified,
    textColor: Color = MaterialTheme.colors.primary,
    backgroundColor: Color = textColor.copy(alpha = 0.4f),
    iconTint: Color = textColor,
    onClick: (() -> Unit)? = null
) {
    val selectedIcon = if (selected) Icons.Outlined.CheckCircle else icon
    val selectedIconTint by animateColorAsState(if (selected) MaterialTheme.colors.onPrimary else iconTint)
    val selectedTextColor by animateColorAsState(if (selected) MaterialTheme.colors.onPrimary else textColor)
    val selectedBackgroundColor by animateColorAsState(if (selected) MaterialTheme.colors.primary else backgroundColor)
    Box(
        modifier = modifier
            .widthIn(min = ChipDefaults.DefaultChipMinWidth)
            .height(ChipDefaults.DefaultChipHeight)
            .background(
                color = selectedBackgroundColor,
                shape = CircleShape
            )
            .border(
                border = BorderStroke(ChipDefaults.DefaultBorderSize, borderColor),
                shape = CircleShape
            )
            .clip(CircleShape)
            .clickable(
                enabled = onClick != null,
                onClick = { if (onClick != null) onClick() }
            ),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(ChipDefaults.DefaultPadding),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            selectedIcon?.let { imageVector ->
                ChipIcon(imageVector = imageVector, tint = selectedIconTint)
            }
            ChipText(
                text = text,
                color = selectedTextColor
            )
        }
    }
}

@Composable
private fun ChipIcon(
    imageVector: ImageVector,
    modifier: Modifier = Modifier,
    contentDescription: String? = null,
    tint: Color
) {
    Icon(
        imageVector = imageVector,
        contentDescription = contentDescription,
        tint = tint,
        modifier = modifier.size(ChipDefaults.DefaultIconSize)
    )
}

@Composable
private fun ChipText(
    text: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.onSurface
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.caption,
        color = color
    )
}

object ChipDefaults {
    val DefaultPadding = 8.dp
    val DefaultIconSize = 20.dp
    val DefaultChipMinWidth = 48.dp
    val DefaultChipHeight = 32.dp
    val DefaultBorderSize = 1.dp
}
