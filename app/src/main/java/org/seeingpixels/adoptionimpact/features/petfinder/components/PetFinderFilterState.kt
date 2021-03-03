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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import org.seeingpixels.adoptionimpact.R

class PetFinderFilterState {
    var location by mutableStateOf(DefaultLocation)
    var type by mutableStateOf("")
    var breed by mutableStateOf("")
    var size by mutableStateOf("")
    var gender by mutableStateOf("")
    var age by mutableStateOf("")
    var coat by mutableStateOf("")
    var status by mutableStateOf("")
    var name by mutableStateOf("")
    var organization by mutableStateOf("")
    var goodWithChildren by mutableStateOf("")
    var goodWithDogs by mutableStateOf("")
    var goodWithCats by mutableStateOf("")
    var declawed by mutableStateOf("")
    var distance by mutableStateOf("")
    var before by mutableStateOf("")
    var after by mutableStateOf("")

    companion object {
        const val DefaultLocation = "Bentonville, AR"
    }
}

enum class PetFinderType(val icon: Int) {
    Cat(R.drawable.ic_cat),
    Dog(R.drawable.ic_dog_side),
    Bird(R.drawable.ic_bird),
    Fish(R.drawable.ic_fish_bowl),
    Rabbit(R.drawable.ic_rabbit),
    Horse(R.drawable.ic_horse),
    Barnyard(R.drawable.ic_barn),
    Other(R.drawable.ic_paw_print)
}

enum class PetFinderSize {
    Small, Medium, Large, XLarge
}

enum class PetFinderGender {
    Male, Female
}

enum class PetFinderAge {
    Baby, Young, Adult, Senior
}

enum class PetFinderCoat {
    Short, Medium, Long, Wire, Hairless, Curly
}
