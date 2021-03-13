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
package org.seeingpixels.bloom.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val BloomColorPaletteLight = lightColors(
    primary = Color(color = 0xfffff1f1),
    secondary = Color(color = 0xff3f2c2c),
    background = Color(color = 0xffffffff),
    surface = Color(color = 0xffffffff).copy(alpha = 0.85f),
    onPrimary = Color(color = 0xff232323),
    onSecondary = Color(color = 0xffffffff),
    onBackground = Color(color = 0xff232323),
    onSurface = Color(color = 0xff232323)
)

val BloomColorPaletteDark = darkColors(
    primary = Color(color = 0xff2d3b2d),
    secondary = Color(color = 0xffb8c9b8),
    background = Color(color = 0xff232323),
    surface = Color(color = 0xffffffff).copy(alpha = 0.15f),
    onPrimary = Color(color = 0xffffffff),
    onSecondary = Color(color = 0xff232323),
    onBackground = Color(color = 0xffffffff),
    onSurface = Color(color = 0xffffffff)
)

val MaterialColors: Colors
    @Composable get() = MaterialTheme.colors
