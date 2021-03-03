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
package org.seeingpixels.adoptionimpact.common.network

import retrofit2.HttpException
import retrofit2.Response

suspend fun <R, T> Response<T>.fold(
    onFailure: (suspend (exception: Throwable) -> R)? = null,
    onSuccess: suspend (value: T) -> R
) = when (isSuccessful) {
    true -> body()?.let { body -> onSuccess(body) }
    else -> onFailure?.let { onFailure(HttpException(this)) }
}
