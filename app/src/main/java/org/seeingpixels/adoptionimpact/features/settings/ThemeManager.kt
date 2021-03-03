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
package org.seeingpixels.adoptionimpact.features.settings

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun ThemeManager(
    modifier: Modifier = Modifier
) {
    BackdropScaffold(
        appBar = {
            TopAppBar(title = { Text(text = "Theme Manager") })
        },
        frontLayerContent = {
        },
        backLayerContent = {
        },
        modifier = modifier.fillMaxSize()
    )
}
