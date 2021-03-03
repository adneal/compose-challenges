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
package org.seeingpixels.adoptionimpact.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val PetOverflowColorPaletteLight = lightColors(
    primary = Color(color = 0xff89c9b8),
    secondary = Color(color = 0xff84a9ac),
    onSecondary = Color.White
)

val PetOverflowColorPaletteDark = darkColors(
    primary = Color(color = 0xff89c9b8),
    secondary = Color(color = 0xff84a9ac),
    onSecondary = Color.White
)

val MaterialColors: Colors
    @Composable get() = MaterialTheme.colors
