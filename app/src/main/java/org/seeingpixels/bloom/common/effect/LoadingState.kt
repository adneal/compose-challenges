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
package org.seeingpixels.bloom.common.effect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import kotlinx.coroutines.async
import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay

@Composable
fun <T> produceLoadingState(
    key1: Any? = null,
    key2: Any? = null,
    key3: Any? = null,
    loadingDelayMillis: Long = DefaultLoadingDelay,
    producer: suspend () -> T
): LoadingState<T> {
    val state by produceState<LoadingState<T>>(LoadingState.Default, key1, key2, key3) {
        val loadingIndicator = async {
            delay(loadingDelayMillis)
            value = LoadingState.Loading
        }
        value = try {
            LoadingState.Success(producer())
        } catch (e: Exception) {
            LoadingState.Error(e)
        } finally {
            loadingIndicator.cancelAndJoin()
        }
    }
    return state
}

sealed class LoadingState<out T> {
    object Default : LoadingState<Nothing>()
    object Loading : LoadingState<Nothing>()
    data class Success<T>(val data: T) : LoadingState<T>()
    data class Error(val error: Exception?) : LoadingState<Nothing>()

    val loading: Boolean
        get() = this == Loading

    val value: T?
        get() = if (this is Success) data else null
}

private const val DefaultLoadingDelay: Long = 750
