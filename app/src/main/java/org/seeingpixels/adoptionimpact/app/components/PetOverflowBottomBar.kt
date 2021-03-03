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
package org.seeingpixels.adoptionimpact.app.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AutoAwesome
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.seeingpixels.adoptionimpact.theme.MaterialColors

@Composable
fun PetOverflowBottomNavigation(
    currentItem: BottomNavigation = BottomNavigation.Discover,
    onNavigationItemClick: (BottomNavigation) -> Unit = {}
) {
    val circleClipModifier = Modifier.clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
    BottomNavigation(modifier = circleClipModifier) {
        BottomNavigation.values().forEach { item ->
            PetOverflowNavigationItem(
                icon = item.icon,
                label = item.label,
                selected = currentItem == item,
                onClick = { onNavigationItemClick(item) }
            )
        }
    }
}

@Composable
private fun RowScope.PetOverflowNavigationItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val tint = with(MaterialColors) {
        if (isLight) onPrimary else primary
    }
    BottomNavigationItem(
        alwaysShowLabel = false,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = tint
            )
        },
        label = {
            Text(
                text = label,
                color = tint
            )
        },
        selected = selected,
        onClick = onClick
    )
}

enum class BottomNavigation(
    val label: String,
    val icon: ImageVector
) {
    Adopt(label = "Adopt", icon = Icons.Rounded.Pets),
    Discover(label = "Discover", icon = Icons.Rounded.AutoAwesome),
    Favorites(label = "Favorites", icon = Icons.Rounded.Favorite),
    Settings(label = "Settings", icon = Icons.Rounded.Menu)
}
