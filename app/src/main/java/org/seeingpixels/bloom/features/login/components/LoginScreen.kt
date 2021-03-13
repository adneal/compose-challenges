package org.seeingpixels.bloom.features.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.seeingpixels.bloom.common.modifier.baselineHeight
import org.seeingpixels.bloom.theme.MaterialColors
import org.seeingpixels.bloom.theme.MaterialTypography

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    onLoginClick: () -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialColors.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login with Email",
            color = MaterialColors.onBackground,
            style = MaterialTypography.h1,
            modifier = Modifier
                .baselineHeight(heightFromBaseline = 184.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(8.dp))
        EmailTextField()
        Spacer(modifier = Modifier.height(8.dp))
        PasswordTextField()
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "By clicking below you agree to our Terms of Service and consent to our Privacy Policy.",
            color = MaterialColors.onBackground,
            style = MaterialTypography.body2,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .baselineHeight(heightFromBaseline = 24.dp, heightToBaseline = 16.dp)
                .fillMaxWidth()
                .wrapContentWidth(Alignment.CenterHorizontally)
        )
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
private fun EmailTextField() {
    var email by remember { mutableStateOf("") }
    OutlinedTextField(
        value = email,
        placeholder = { Text("Email address") },
        textStyle = MaterialTypography.body1,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Email,
            imeAction = ImeAction.Next
        ),
        colors = TextFieldDefaults.outlinedTextFieldColors(MaterialColors.onBackground),
        singleLine = true,
        onValueChange = { input -> email = input },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    )
}

@Composable
private fun PasswordTextField() {
    var password by remember { mutableStateOf("") }
    OutlinedTextField(
        value = password,
        placeholder = { Text("Password (8+ characters)") },
        textStyle = MaterialTypography.body1,
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done
        ),
        isError = password.length < 8,
        singleLine = true,
        colors = TextFieldDefaults.outlinedTextFieldColors(MaterialColors.onBackground),
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = { input -> password = input },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
    )
}