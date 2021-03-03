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

import android.content.Context
import android.content.SharedPreferences
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.seeingpixels.adoptionimpact.common.network.BaseUrl
import org.seeingpixels.adoptionimpact.features.petfinder.auth.PetFinderAuthService
import org.seeingpixels.adoptionimpact.features.petfinder.auth.PetFinderInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber

val petFinder = module {
    single { providePetFinderBaseUrl() }
    single { providePetFinderService(get()) }
    single { provideOkHttpClient(get(), get()) }
    single { providePreferences(androidContext()) }
    single { providePetFinderAuthService(get(), get()) }
}

private fun providePetFinderBaseUrl(): BaseUrl {
    return BaseUrl { "https://api.petfinder.com/v2/" }
}

private fun providePetFinderAuthService(
    baseUrl: BaseUrl,
    moshi: Moshi
): PetFinderAuthService {
    return Retrofit.Builder()
        .client(OkHttpClient.Builder().build())
        .baseUrl(baseUrl.url())
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
        .create(PetFinderAuthService::class.java)
}

private fun providePetFinderService(
    retrofit: Retrofit
): PetFinderService {
    return retrofit.create(PetFinderService::class.java)
}

private fun provideOkHttpClient(
    authService: PetFinderAuthService,
    preferences: SharedPreferences
): OkHttpClient {
    val logger = HttpLoggingInterceptor.Logger { message -> Timber.tag(OkHttpTag).d(message) }
    return OkHttpClient.Builder()
        .addNetworkInterceptor(
            HttpLoggingInterceptor(logger).apply {
                setLevel(HttpLoggingInterceptor.Level.BODY)
            }
        )
        .addNetworkInterceptor(PetFinderInterceptor(authService, preferences))
        .build()
}

private fun providePreferences(context: Context): SharedPreferences {
    return context.getSharedPreferences("special_secrets", 0)
}

private const val OkHttpTag = "OkHttp"
