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

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Female
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Male
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.transform.RoundedCornersTransformation
import dev.chrisbanes.accompanist.coil.CoilImage
import org.seeingpixels.adoptionimpact.common.components.Chip
import org.seeingpixels.adoptionimpact.common.components.Spacing
import org.seeingpixels.adoptionimpact.features.adoption.data.Animal
import org.seeingpixels.adoptionimpact.theme.MaterialColors
import org.seeingpixels.adoptionimpact.theme.MaterialTypography
import kotlin.math.roundToInt

@Composable
fun AnimalGridItem(
    animal: Animal,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .clickable(onClick = onClick)
    ) {
        Column {
            animal.croppedImageUrl?.let { imageUrl ->
                AnimalImage(imageUrl = imageUrl)
                Spacing.SmallVerticalSpacer()
            }
            AnimalName(animal.name)
            animal.primaryBreed.let { breed ->
                Spacing.TinyVerticalSpacer()
                IconTextRow(
                    icon = Icons.Rounded.Pets,
                    iconContentDescription = "breed",
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    text = breed
                )
            }
            animal.distance?.let { distance ->
                Spacing.TinyVerticalSpacer()
                IconTextRow(
                    icon = Icons.Rounded.LocationOn,
                    iconContentDescription = "distance",
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp),
                    text = when {
                        distance < 1 -> "Less than 1 mile away"
                        else -> "${distance.roundToInt()} miles away"
                    }
                )
            }
            Spacing.SmallVerticalSpacer()
            LazyRow(
                contentPadding = PaddingValues(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(space = 8.dp)
            ) {
                animal.gender.let { gender ->
                    item {
                        val (icon, color) = when (gender) {
                            "Male" -> Icons.Rounded.Male to Color(color = 0xff7579e7)
                            "Female" -> Icons.Rounded.Female to Color(color = 0xfffca3cc)
                            else -> null to MaterialColors.primary
                        }
                        Chip(text = gender, icon = icon, textColor = color)
                    }
                }
                animal.age.let { age ->
                    item {
                        Chip(text = age)
                    }
                }
                animal.size.let { size ->
                    item {
                        Chip(text = size)
                    }
                }
            }
            Spacing.SmallVerticalSpacer()
        }
    }
}

@Composable
private fun AnimalImage(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    var favorite by remember { mutableStateOf(false) }
    val favoriteColor = Color(color = 0xffff5555)
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
    ) {
        CoilImage(
            fadeIn = true,
            data = imageUrl,
            contentDescription = null,
            requestBuilder = {
                transformations(RoundedCornersTransformation(radius = 20f))
            },
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        IconButton(
            onClick = { favorite = !favorite },
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentWidth(Alignment.End)
                .padding(4.dp)
                .background(
                    color = animateColorAsState(
                        (if (favorite) favoriteColor else Color.Black).copy(alpha = 0.2f)
                    ).value,
                    shape = CircleShape
                )
        ) {
            Icon(
                imageVector = if (favorite) Icons.Rounded.Favorite else Icons.Rounded.FavoriteBorder,
                contentDescription = "favorite",
                tint = animateColorAsState(if (favorite) favoriteColor else Color.White).value
            )
        }
    }
}

@Composable
private fun AnimalName(name: String?) {
    Text(
        text = name ?: "--",
        fontWeight = FontWeight.Bold,
        style = MaterialTypography.h5,
        color = MaterialColors.onSurface,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
    )
}
