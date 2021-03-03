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
package org.seeingpixels.adoptionimpact.theme.palette

import androidx.compose.material.Colors
import androidx.compose.ui.graphics.Color

class DarculaColorPalette : ColorPalette {

    override fun lightColors(): Colors = androidx.compose.material.lightColors(
        primary = Color(color = 0xff50fa7b),
        secondary = Color(color = 0xffbd93f9)
    )

    override fun darkColors(): Colors = androidx.compose.material.darkColors(
        primary = Color(color = 0xff50fa7b),
        secondary = Color(color = 0xffbd93f9),
        background = Color(color = 0xff44475a),
        surface = Color(color = 0xff282a36)
    )
}
