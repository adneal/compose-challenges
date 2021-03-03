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
package org.seeingpixels.adoptionimpact.features.petfinder.data

data class AnimalResponse(
    val links: Links? = Links(),
    val age: String = "",
    val attributes: Attributes? = Attributes(),
    val breeds: Breeds = Breeds(),
    val coat: String? = null,
    val colors: Colors = Colors(),
    val contact: Contact = Contact(),
    val description: String? = null,
    val distance: Double? = 0.0,
    val environment: Environment = Environment(),
    val gender: String = "",
    val id: Int = 0,
    val name: String = "",
    val organization_animal_id: String? = null,
    val organization_id: String? = null,
    val photos: List<Photo> = listOf(),
    val primary_photo_cropped: PrimaryPhotoCropped? = PrimaryPhotoCropped(),
    val published_at: String? = null,
    val size: String = "",
    val species: String = "",
    val status: String? = null,
    val status_changed_at: String? = null,
    val tags: List<String?> = listOf(),
    val type: String = "",
    val url: String? = null,
    val videos: List<Any?> = listOf()
) {
    data class Links(
        val organization: Organization = Organization(),
        val self: Self = Self(),
        val type: Type = Type()
    ) {
        data class Organization(val href: String? = null)
        data class Self(val href: String? = null)
        data class Type(val href: String? = null)
    }

    data class Attributes(
        val declawed: Boolean? = false,
        val house_trained: Boolean? = false,
        val shots_current: Boolean? = false,
        val spayed_neutered: Boolean? = false,
        val special_needs: Boolean? = false
    )

    data class Breeds(
        val mixed: Boolean? = false,
        val primary: String = "",
        val secondary: String? = null,
        val unknown: Boolean? = false
    )

    data class Colors(
        val primary: String? = null,
        val secondary: String? = null,
        val tertiary: String? = null
    )

    data class Contact(
        val address: Address = Address(),
        val email: String? = null,
        val phone: String? = null
    ) {
        data class Address(
            val address1: String? = null,
            val address2: String? = null,
            val city: String? = null,
            val country: String? = null,
            val postcode: String? = null,
            val state: String? = null
        )

        val fullAddress: String = buildString {
            when {
                address.address1 != null -> append(address.address1).append(" ,")
                address.city != null -> append(address.city).append(" ,")
                address.state != null -> append(address.state)
            }
        }
    }

    data class Environment(
        val cats: Boolean? = false,
        val children: Boolean? = false,
        val dogs: Boolean? = false
    )

    data class Photo(
        val full: String? = null,
        val large: String? = null,
        val medium: String? = null,
        val small: String? = null
    )

    data class PrimaryPhotoCropped(
        val full: String? = null,
        val large: String? = null,
        val medium: String? = null,
        val small: String? = null
    ) {
        val imageUrl: String? = when {
            full != null -> full
            large != null -> large
            medium != null -> medium
            small != null -> small
            else -> null
        }
    }
}
