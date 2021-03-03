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
package org.seeingpixels.adoptionimpact.features.petfinder

import org.seeingpixels.adoptionimpact.features.petfinder.data.PaginatedAnimalResponse
import org.seeingpixels.adoptionimpact.features.petfinder.data.SingleAnimalResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PetFinderService {

    @GET("animals")
    suspend fun animalsForLocation(
        @Query("location") location: String,
        @Query("type") type: String? = null,
        @Query("breed") breed: String? = null,
        @Query("size") size: String? = null,
        @Query("gender") gender: String? = null,
        @Query("age") age: String? = null,
        @Query("color") color: String? = null,
        @Query("coat") coat: String? = null,
        @Query("status") status: String? = null,
        @Query("name") name: String? = null,
        @Query("organization") organization: String? = null,
        @Query("good_with_children") goodWithChildren: Boolean? = null,
        @Query("good_with_dogs") goodWithDogs: Boolean? = null,
        @Query("good_with_cats") goodWithCats: Boolean? = null,
        @Query("house_trained") houseTrained: Boolean? = null,
        @Query("declawed") declawed: Boolean? = null,
        @Query("distance") distance: Int = 100,
        @Query("before") before: String? = null,
        @Query("after") after: String? = null,
        @Query("sort") sort: String? = "distance",
        @Query("page") page: Int = 1,
        @Query("limit") limit: Int = 100
    ): Response<PaginatedAnimalResponse>

    @GET("animals/{id}")
    suspend fun animal(@Path("id") id: String): Response<SingleAnimalResponse>
}
