package org.seeingpixels.bloom.features.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.seeingpixels.bloom.theme.MaterialColors
import org.seeingpixels.bloom.theme.MaterialTypography

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialColors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(184.dp))
        Text(
            text = "Login with Email",
            color = MaterialColors.onBackground,
            style = MaterialTypography.h1
        )
        SimpleTextField(placeholder = "Email address")
        Spacer(modifier = Modifier.height(8.dp))
        SimpleTextField(placeholder = "Password (8+ characters)")
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "By click below you agree to our Terms of Service and consent to our Privacy Policy.",
            color = MaterialColors.onBackground,
            style = MaterialTypography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = onLoginClick,
            colors = ButtonDefaults.buttonColors(MaterialColors.secondary),
            shape = CircleShape,
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp)
                .height(48.dp)
        ) {
            Text(
                text = "Login",
                color = MaterialColors.onSecondary,
                style = MaterialTypography.button
            )
        }
    }
}

@Composable
private fun SimpleTextField(placeholder: String) {
    var input by remember { mutableStateOf("") }
    OutlinedTextField(
        value = input,
        placeholder = { Text(placeholder) },
        textStyle = MaterialTypography.body1,
        onValueChange = { input = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    )
}