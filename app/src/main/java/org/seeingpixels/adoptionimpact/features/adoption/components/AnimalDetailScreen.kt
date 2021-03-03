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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ChildCare
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.Female
import androidx.compose.material.icons.rounded.LocationCity
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Male
import androidx.compose.material.icons.rounded.Medication
import androidx.compose.material.icons.rounded.MoreHoriz
import androidx.compose.material.icons.rounded.OpenInBrowser
import androidx.compose.material.icons.rounded.Pets
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.systemBarsPadding
import org.seeingpixels.adoptionimpact.R
import org.seeingpixels.adoptionimpact.common.components.Chip
import org.seeingpixels.adoptionimpact.common.components.FlowRow
import org.seeingpixels.adoptionimpact.common.components.Spacing
import org.seeingpixels.adoptionimpact.features.adoption.data.Animal
import org.seeingpixels.adoptionimpact.theme.MaterialColors
import org.seeingpixels.adoptionimpact.theme.MaterialTypography
import java.util.Locale
import kotlin.math.roundToInt

@Composable
@OptIn(ExperimentalMaterialApi::class, ExperimentalAnimationApi::class)
fun AnimalDetailScreen(
    animal: Animal,
    modifier: Modifier = Modifier,
) {
    val scaffoldState = rememberBackdropScaffoldState(initialValue = BackdropValue.Revealed)
    var expandAttrs by remember { mutableStateOf(false) }
    BackdropScaffold(
        appBar = {},
        frontLayerShape = RectangleShape,
        frontLayerContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                LabeledSection(label = "About Me") {
                    Text(
                        text = animal.name,
                        style = MaterialTypography.h4
                    )
                    Spacing.TinyVerticalSpacer()
                    IconTextRow(
                        icon = Icons.Rounded.Pets,
                        iconContentDescription = "breed",
                        text = animal.primaryBreed
                    )
                    animal.distance?.let {
                        Spacing.TinyVerticalSpacer()
                        IconTextRow(
                            icon = Icons.Rounded.LocationOn,
                            iconContentDescription = "distance",
                            text = when {
                                animal.distance < 1 -> "Less than 1 mile away"
                                else -> "${animal.distance.roundToInt()} miles away"
                            }
                        )
                    }
                }
                Spacing.MediumVerticalSpacer()
                LabeledSection(
                    label = "Attributes",
                    onClick = { expandAttrs = !expandAttrs }
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        val (icon, tint) = when (animal.gender) {
                            "Male" -> Icons.Rounded.Male to Color(color = 0xff7579e7)
                            "Female" -> Icons.Rounded.Female to Color(color = 0xfffca3cc)
                            else -> Icons.Rounded.Pets to MaterialColors.primary
                        }
                        RoundedCornerButton(
                            label = animal.gender.toLowerCase(Locale.getDefault()),
                            icon = icon,
                            tint = tint
                        )
                        RoundedCornerButton(
                            label = animal.age.toLowerCase(Locale.getDefault()),
                            icon = Icons.Rounded.Pets,
                            tint = MaterialColors.primary
                        )
                        RoundedCornerButton(
                            label = animal.size.toLowerCase(Locale.getDefault()),
                            icon = Icons.Rounded.Pets,
                            tint = MaterialColors.primary
                        )
                        RoundedCornerButton(
                            label = "vaccinated",
                            icon = Icons.Rounded.Medication,
                            tint = MaterialColors.primary
                        )
                    }
                    AnimatedVisibility(visible = expandAttrs) {
                        Column {
                            Spacing.LargeVerticalSpacer()
                            FlowRow {
                                Chip(text = "neutered", selected = true)
                                Chip(text = "house trained", selected = true)
                                Chip(text = "special needs", selected = false)
                                Chip(text = "declawed", selected = false)
                            }
                        }
                    }
                }
                Spacing.MediumVerticalSpacer()
                LabeledSection(label = "Environment") {
                    Spacing.MediumVerticalSpacer()
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        RoundedCornerButton(
                            label = "dogs",
                            icon = painterResource(id = R.drawable.ic_dog_side),
                            tint = MaterialColors.error
                        )
                        RoundedCornerButton(
                            label = "cats",
                            icon = painterResource(id = R.drawable.ic_cat),
                            tint = MaterialColors.primary
                        )
                        RoundedCornerButton(
                            label = "children",
                            icon = Icons.Rounded.ChildCare,
                            tint = MaterialColors.error
                        )
                    }
                }
                Spacing.MediumVerticalSpacer()
                LabeledSection(label = "Contact Info") {
                    FlowRow {
                        if (animal.contact.email != null) Chip(
                            text = animal.contact.email,
                            icon = Icons.Rounded.Email
                        )
                        if (animal.contact.phone != null) Chip(
                            text = animal.contact.phone,
                            icon = Icons.Rounded.Phone
                        )
                        if (animal.contact.fullAddress != null) Chip(
                            text = animal.contact.fullAddress,
                            icon = Icons.Rounded.LocationCity
                        )
                    }
                }
            }
        },
        backLayerContent = {
            Box {
                AnimalImage(imageUrl = animal.croppedImageUrl!!)
                DetailToolbar(isConcealed = scaffoldState.isConcealed)
            }
        },
        scaffoldState = scaffoldState,
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
    )
}

@Composable
private fun DetailToolbar(isConcealed: Boolean) {
    val backgroundColor by animateColorAsState(if (isConcealed) MaterialColors.surface else Color.Transparent)
    TopAppBar(
        title = {},
        backgroundColor = backgroundColor,
        elevation = 0.dp,
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Rounded.Close,
                    contentDescription = "close"
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Rounded.OpenInBrowser,
                    contentDescription = "open in browser"
                )
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Rounded.FavoriteBorder,
                    contentDescription = "favorite"
                )
            }
        }
    )
}

@Composable
private fun AnimalImage(
    imageUrl: String
) {
    CoilImage(
        data = imageUrl,
        contentDescription = "animal photo",
        contentScale = ContentScale.Crop,
        modifier = Modifier.height(350.dp)
    )
}

@Composable
private fun LabeledSection(
    label: String,
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                enabled = onClick != null,
                onClick = { onClick?.invoke() }
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row {
                Text(
                    text = label,
                    color = MaterialColors.primary,
                    style = MaterialTypography.body1,
                    fontWeight = FontWeight.Bold
                )
                if (onClick != null) {
                    Icon(
                        imageVector = Icons.Rounded.MoreHoriz,
                        contentDescription = "expand attributes",
                        tint = MaterialColors.primary,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                    )
                }
            }
            Spacing.MediumVerticalSpacer()
            content()
        }
    }
}
