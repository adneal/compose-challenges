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
package org.seeingpixels.bloom.common.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Spacing {

    private val TinySpace: Dp = 4.dp
    private val SmallSpace: Dp = 8.dp
    private val MediumSpace: Dp = 16.dp
    private val LargeSpace: Dp = 24.dp

    @Composable
    fun TinyVerticalSpacer() = Spacer(modifier = Modifier.height(TinySpace))

    @Composable
    fun TinyHorizontalSpacer() = Spacer(modifier = Modifier.width(TinySpace))

    @Composable
    fun SmallHorizontalSpacer() = Spacer(modifier = Modifier.width(SmallSpace))

    @Composable
    fun SmallVerticalSpacer() = Spacer(modifier = Modifier.height(SmallSpace))

    @Composable
    fun MediumVerticalSpacer() = Spacer(modifier = Modifier.height(MediumSpace))

    @Composable
    fun MediumHorizontalSpacer() = Spacer(modifier = Modifier.width(MediumSpace))

    @Composable
    fun LargeVerticalSpacer() = Spacer(modifier = Modifier.height(LargeSpace))

    @Composable
    fun LargeHorizontalSpacer() = Spacer(modifier = Modifier.width(LargeSpace))
}
