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
package org.seeingpixels.adoptionimpact.features.petfinder.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.seeingpixels.adoptionimpact.common.components.Chip
import org.seeingpixels.adoptionimpact.common.components.FlowRow
import org.seeingpixels.adoptionimpact.common.components.MainAxisAlignment
import org.seeingpixels.adoptionimpact.common.components.Spacing
import org.seeingpixels.adoptionimpact.theme.MaterialColors
import org.seeingpixels.adoptionimpact.theme.MaterialTypography

@Composable
fun PetFinderFilterList(
    filterState: PetFinderFilterState,
    modifier: Modifier = Modifier,
    onCancel: () -> Unit,
    onSave: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialColors.surface)
    ) {
        LazyColumn(modifier = Modifier.weight(weight = 1f)) {
            locationFilter(location = filterState.location) { location ->
                filterState.location = location
            }
            item { Spacing.SmallVerticalSpacer() }
            typeFilter()
            item { Spacing.SmallVerticalSpacer() }
            sizeFilter()
            item { Spacing.SmallVerticalSpacer() }
            genderFilter()
            item { Spacing.SmallVerticalSpacer() }
            ageFilter()
            item { Spacing.SmallVerticalSpacer() }
            coatFilter()
        }
        SaveButtonRow(
            onCancel = onCancel,
            onSave = onSave
        )
    }
}

@Composable
private fun SaveButtonRow(
    onCancel: () -> Unit,
    onSave: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = 6.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Filter Search")
            OutlinedButton(onClick = onCancel) {
                Text(text = "cancel")
            }
            Button(onClick = onSave) {
                Text(text = "save")
            }
        }
    }
}

private fun LazyListScope.locationFilter(
    location: String,
    onLocationChange: (String) -> Unit
) {
    item {
        FilterCard(label = "Location") {
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = location,
                leadingIcon = {
                    Icon(
                        Icons.Rounded.LocationOn,
                        contentDescription = "location",
                        tint = MaterialColors.primary
                    )
                },

                maxLines = 1,
                onValueChange = onLocationChange
            )
        }
    }
}

private fun LazyListScope.typeFilter() {
    item {
        FilterCard(
            label = "Type",
            mainAxisAlignment = MainAxisAlignment.SpaceEvenly,
            mainAxisSpacing = 24.dp,
            crossAxisSpacing = 16.dp
        ) {
            PetFinderType.values().forEach { type ->
                TypeButton(
                    icon = type.icon,
                    text = type.name
                )
            }
        }
    }
}

private fun LazyListScope.sizeFilter() {
    item {
        FilterCard(label = "Size") {
            PetFinderSize.values().forEach { type ->
                Chip(text = type.name, selected = false)
            }
        }
    }
}

private fun LazyListScope.genderFilter() {
    item {
        FilterCard(label = "Gender") {
            PetFinderGender.values().forEach { type ->
                Chip(text = type.name, selected = false)
            }
        }
    }
}

private fun LazyListScope.ageFilter() {
    item {
        FilterCard(label = "Age") {
            PetFinderAge.values().forEach { type ->
                Chip(text = type.name, selected = false)
            }
        }
    }
}

private fun LazyListScope.coatFilter() {
    item {
        FilterCard(label = "Coat") {
            PetFinderCoat.values().forEach { type ->
                Chip(text = type.name, selected = false)
            }
        }
    }
}

@Composable
private fun FilterCard(
    label: String,
    modifier: Modifier = Modifier,
    mainAxisAlignment: MainAxisAlignment = MainAxisAlignment.Start,
    mainAxisSpacing: Dp = 8.dp,
    crossAxisSpacing: Dp = 12.dp,
    content: @Composable () -> Unit
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = label,
                style = MaterialTypography.body1,
                fontWeight = FontWeight.Bold
            )
            Spacing.MediumVerticalSpacer()
            FlowRow(
                mainAxisAlignment = mainAxisAlignment,
                mainAxisSpacing = mainAxisSpacing,
                crossAxisSpacing = crossAxisSpacing,
            ) {
                content()
            }
        }
    }
}

@Composable
private fun TypeButton(
    icon: Int,
    text: String,
    contentDescription: String? = text,
    onClick: () -> Unit = {}
) {
    val iconShape = RoundedCornerShape(
        topStart = CornerSize(0.dp),
        topEnd = CornerSize(12.dp),
        bottomEnd = CornerSize(0.dp),
        bottomStart = CornerSize(12.dp)
    )
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        IconButton(
            onClick = onClick,
            modifier = Modifier
                .background(
                    color = MaterialColors.primary.copy(alpha = 0.4f),
                    shape = iconShape
                )
                .clip(iconShape)
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = contentDescription,
                tint = MaterialColors.primary
            )
        }
        Spacing.SmallVerticalSpacer()
        Text(text = text)
    }
}
