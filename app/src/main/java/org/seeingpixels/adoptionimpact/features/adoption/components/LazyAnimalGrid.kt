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

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.seeingpixels.adoptionimpact.features.adoption.data.Animal

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun LazyAnimalGrid(
    animals: List<Animal>,
    modifier: Modifier = Modifier,
    cells: GridCells = GridCells.Adaptive(LazyAnimalGridDefaults.MinCellSize),
    lazyListState: LazyListState = rememberLazyListState(),
    onAnimalClick: (Animal) -> Unit
) {
    LazyVerticalGrid(
        cells = cells,
        modifier = modifier,
        state = lazyListState
    ) {
        items(animals) { animal ->
            AnimalGridItem(animal = animal) {
                onAnimalClick(animal)
            }
        }
    }
}

object LazyAnimalGridDefaults {
    val MinCellSize = 185.dp
}
