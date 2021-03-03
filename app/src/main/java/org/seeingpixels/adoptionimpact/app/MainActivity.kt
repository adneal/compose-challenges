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
package org.seeingpixels.adoptionimpact.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import org.seeingpixels.adoptionimpact.app.components.PetOverflowScaffold
import org.seeingpixels.adoptionimpact.common.effect.inject
import org.seeingpixels.adoptionimpact.features.adoption.components.AnimalDetailScreen
import org.seeingpixels.adoptionimpact.features.adoption.data.AnimalRepository
import org.seeingpixels.adoptionimpact.features.petfinder.components.PetFinderFilterState
import org.seeingpixels.adoptionimpact.theme.MaterialColors
import org.seeingpixels.adoptionimpact.theme.PetOverflowTheme
import org.seeingpixels.adoptionimpact.theme.SystemUiController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val navController = rememberNavController()
            PetOverflowTheme {
                val repository by inject<AnimalRepository>()
                val filterState = remember { PetFinderFilterState() }
                val animals by repository.animals(
                    location = filterState.location
                ).collectAsState(initial = emptyList())
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ) {
                    composable(route = "home") {
                        PetOverflowScaffold(
                            animals = animals,
                            filterState = filterState,
                            onAnimalClick = { animal ->
                                navController.navigate(route = "detail/${animal.id}")
                            }
                        )
                    }
                    composable(
                        route = "detail/{id}",
                        arguments = listOf(
                            navArgument(name = "id") {
                                type = NavType.StringType
                            }
                        )
                    ) { entry ->
                        val animalId = entry.arguments?.getString("id")!!
                        val animal by repository.animal(id = animalId).collectAsState(null)
                        if (animal != null) AnimalDetailScreen(animal = animal!!)
                    }
                }
                SystemUiController(window).apply {
                    setStatusBarColor(
                        darkIcons = MaterialColors.isLight,
                        color = MaterialColors.surface
                    )
                }
            }
        }
    }
}
