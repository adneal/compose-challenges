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
package org.seeingpixels.bloom.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import dev.chrisbanes.accompanist.insets.systemBarsPadding
import org.seeingpixels.bloom.features.home.components.HomeScreen
import org.seeingpixels.bloom.features.login.components.LoginScreen
import org.seeingpixels.bloom.features.welcome.components.WelcomeScreen
import org.seeingpixels.bloom.theme.BloomTheme
import org.seeingpixels.bloom.theme.MaterialColors
import org.seeingpixels.bloom.theme.SystemUiController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val navController = rememberNavController()
            BloomTheme {
                NavHost(navController = navController, startDestination = "welcome") {
                    composable(route = "welcome") {
                        WelcomeScreen(
                            modifier = Modifier.systemBarsPadding(),
                            onCreateAccountClick = { /*TODO*/ },
                            onLoginClick = { navController.navigate(route = "login") }
                        )
                        SystemUiController(window).apply {
                            setStatusBarColor(color = MaterialColors.primary)
                        }
                    }
                    composable(route = "login") {
                        LoginScreen(modifier = Modifier.systemBarsPadding()) {
                            navController.navigate(route = "home")
                        }
                        SystemUiController(window).apply {
                            setStatusBarColor(color = MaterialColors.background)
                        }
                    }
                    composable(route = "home") {
                        HomeScreen(modifier = Modifier.systemBarsPadding())
                        SystemUiController(window).apply {
                            setStatusBarColor(color = MaterialColors.background)
                        }
                    }
                }
            }
        }
    }

}
