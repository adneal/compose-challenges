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
package org.seeingpixels.adoptionimpact.features.petfinder.auth

import android.content.SharedPreferences
import androidx.core.content.edit
import kotlinx.coroutines.runBlocking
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import org.seeingpixels.adoptionimpact.features.petfinder.data.AuthTokenBody

class PetFinderInterceptor(
    private val authService: PetFinderAuthService,
    private val preferences: SharedPreferences
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val authRequest: (String) -> Request = { token ->
            chain.request()
                .newBuilder()
                .addHeader(AuthorizationHeader, "$BearerHeader $token")
                .build()
        }
        val cachedToken = preferences.getString(AuthTokenPrefKey, null)
        return if (cachedToken != null) {
            chain.proceed(authRequest(cachedToken)).apply {
                if (code == 401) preferences.edit {
                    putString(AuthTokenPrefKey, null)
                }
            }
        } else {
            val authorization = runBlocking {
                authService.authenticate(AuthTokenBody.PetOverflowAuthToken)
            }
            preferences.edit {
                putString(AuthTokenPrefKey, authorization.access_token)
            }
            chain.proceed(authRequest(authorization.access_token))
        }
    }

    companion object {
        const val AuthTokenPrefKey = "pet_finder_token"
        const val AuthorizationHeader = "Authorization"
        const val BearerHeader = "Bearer"
    }
}
