package org.seeingpixels.bloom.features.welcome.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import org.seeingpixels.bloom.common.modifier.baselineHeight
import org.seeingpixels.bloom.theme.BloomIcons
import org.seeingpixels.bloom.theme.MaterialColors
import org.seeingpixels.bloom.theme.MaterialTypography

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onCreateAccountClick: () -> Unit,
    onLoginClick: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialColors.primary)
    ) {
        Column {
            Spacer(modifier = Modifier.height(72.dp))
            Image(
                painter = BloomIcons.welcomeBackground,
                contentDescription = "background",
                modifier = Modifier.wrapContentSize()
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentHeight(Alignment.Bottom),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = BloomIcons.illos,
                contentDescription = "illos",
                modifier = Modifier
                    .wrapContentSize(Alignment.CenterEnd)
                    .padding(start = 88.dp)
            )
            Spacer(modifier = Modifier.height(48.dp))
            Image(
                painter = BloomIcons.logo,
                contentDescription = "logo",
                modifier = Modifier.wrapContentSize(Alignment.Center)
            )
            Text(
                text = "Beautiful home and garden solutions.",
                style = MaterialTypography.subtitle1,
                color = MaterialColors.onBackground,
                modifier = Modifier
                    .baselineHeight(heightFromBaseline = 32.dp, heightToBaseline = 40.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
            Button(
                onClick = onCreateAccountClick,
                colors = ButtonDefaults.buttonColors(MaterialColors.secondary),
                shape = CircleShape,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                    .height(48.dp)
            ) {
                Text(
                    text = "Create Account",
                    color = MaterialColors.onSecondary,
                    style = MaterialTypography.button
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
                    .height(48.dp)
                    .clip(CircleShape)
                    .clickable(onClick = onLoginClick),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Login",
                    color = MaterialColors.onBackground,
                    style = MaterialTypography.button
                )
            }
            Spacer(modifier = Modifier.height(56.dp))
        }
    }
}