package org.seeingpixels.bloom.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import org.seeingpixels.bloom.R

object BloomIcons {
    val logo: Painter
        @Composable get() = painterResource(
            id = if (MaterialColors.isLight) R.drawable.ic_light_logo else R.drawable.ic_dark_logo
        )

    val welcomeBackground: Painter
        @Composable get() = painterResource(
            id = if (MaterialColors.isLight) R.drawable.ic_light_welcome_bg else R.drawable.ic_dark_welcome_bg
        )

    val illos: Painter
        @Composable get() = painterResource(
            id = if (MaterialColors.isLight) R.drawable.ic_light_welcome_illos else R.drawable.ic_dark_welcome_illos
        )
}