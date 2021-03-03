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

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.DrawerValue
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FilterList
import androidx.compose.material.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import dev.chrisbanes.accompanist.insets.systemBarsPadding
import kotlinx.coroutines.launch
import org.seeingpixels.adoptionimpact.common.components.DrawerDirection
import org.seeingpixels.adoptionimpact.common.components.ModalDrawer
import org.seeingpixels.adoptionimpact.features.adoption.components.LazyAnimalGrid
import org.seeingpixels.adoptionimpact.features.adoption.data.Animal
import org.seeingpixels.adoptionimpact.features.petfinder.components.PetFinderFilterList
import org.seeingpixels.adoptionimpact.features.petfinder.components.PetFinderFilterState

@Composable
fun PetOverflowScaffold(
    animals: List<Animal>,
    filterState: PetFinderFilterState,
    modifier: Modifier = Modifier,
    initialTab: BottomNavigation = BottomNavigation.Adopt,
    onAnimalClick: (Animal) -> Unit,
    onNavigationItemClick: (BottomNavigation) -> Unit = {}
) {
    val scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    var bottomNavigationItem by remember { mutableStateOf(initialTab) }
    ModalDrawer(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding(),
        drawerState = drawerState,
        drawerDirection = DrawerDirection.End,
        drawerContent = {
            PetFinderFilterList(
                filterState = filterState,
                onCancel = { scope.launch { drawerState.close() } },
                onSave = { scope.launch { drawerState.close() } }
            )
        },
        content = {
            Scaffold(
                topBar = { PetOverflowTopAppBar() },
                content = { paddingValues ->
                    LazyAnimalGrid(
                        animals = animals,
                        modifier = Modifier.padding(paddingValues),
                        onAnimalClick = onAnimalClick
                    )
                },
                bottomBar = {
                    PetOverflowBottomNavigation(
                        currentItem = bottomNavigationItem,
                        onNavigationItemClick = { item ->
                            bottomNavigationItem = item
                            onNavigationItemClick(item)
                        }
                    )
                },
                floatingActionButton = {
                    FloatingActionButton(onClick = { scope.launch { drawerState.open() } }) {
                        Icon(
                            Icons.Rounded.FilterList,
                            contentDescription = "filter list"
                        )
                    }
                }
            )
        }
    )
}
