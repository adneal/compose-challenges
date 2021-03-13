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
package org.seeingpixels.bloom.app.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import org.seeingpixels.bloom.theme.MaterialColors

@Composable
fun BloomBottomNavigation(
    modifier: Modifier = Modifier,
    currentItem: BottomNavigation = BottomNavigation.Home,
    onNavigationItemClick: (BottomNavigation) -> Unit = {}
) {
    BottomNavigation(
        backgroundColor = MaterialColors.primary,
        modifier = modifier
    ) {
        BottomNavigation.values().forEach { item ->
            BloomNavigationItem(
                icon = item.icon,
                label = item.label,
                selected = currentItem == item,
                onClick = { onNavigationItemClick(item) }
            )
        }
    }
}

@Composable
private fun RowScope.BloomNavigationItem(
    icon: ImageVector,
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    BottomNavigationItem(
        alwaysShowLabel = false,
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = MaterialColors.onPrimary
            )
        },
        label = {
            Text(
                text = label,
                color = MaterialColors.onPrimary
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
    Home(label = "Home", icon = Icons.Rounded.Home),
    Favorites(label = "Favorites", icon = Icons.Rounded.Favorite),
    Profile(label = "Profile", icon = Icons.Rounded.AccountCircle),
    Cart(label = "Cart", icon = Icons.Rounded.ShoppingCart)
}
