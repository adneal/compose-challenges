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
package org.seeingpixels.adoptionimpact.features.facts.data

data class PetFactResponse(
    val __v: Int = 0,
    val _id: String? = null,
    val createdAt: String? = null,
    val deleted: Boolean = false,
    val source: String? = null,
    val status: Status = Status(),
    val text: String? = null,
    val type: String? = null,
    val updatedAt: String? = null,
    val used: Boolean = false,
    val user: String? = null
) {
    data class Status(
        val sentCount: Int = 0,
        val verified: Boolean = false
    )
}
