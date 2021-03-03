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
package org.seeingpixels.adoptionimpact.features.adoption.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.seeingpixels.adoptionimpact.common.network.fold
import org.seeingpixels.adoptionimpact.features.petfinder.PetFinderService
import org.seeingpixels.adoptionimpact.features.petfinder.data.AnimalResponse
import timber.log.Timber

interface AnimalRepository {
    fun animals(location: String): Flow<List<Animal>>
    fun animal(id: String): Flow<Animal>
}

class AnimalRepositoryImpl(
    private val petFinderService: PetFinderService
) : AnimalRepository {

    private val animalMapper: (AnimalResponse) -> Animal = { response ->
        Animal(
            id = response.id,
            age = response.age,
            name = response.name,
            size = response.size,
            gender = response.gender,
            distance = response.distance,
            primaryBreed = response.breeds.primary,
            croppedImageUrl = response.primary_photo_cropped?.imageUrl,
            contact = response.contact
        )
    }

    override fun animals(location: String): Flow<List<Animal>> {
        return flow {
            petFinderService.animalsForLocation(location).fold(
                onFailure = { error -> Timber.e(error) },
                onSuccess = { response -> emit(response.animals.map(animalMapper)) }
            )
        }
    }

    override fun animal(id: String): Flow<Animal> {
        return flow {
            petFinderService.animal(id = id).fold(
                onFailure = { error -> Timber.e(error) },
                onSuccess = { response -> emit(animalMapper(response.animal)) }
            )
        }
    }
}
