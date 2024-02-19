package com.example.rideassistant.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.rideassistant.R

@Composable
fun PasswordInput(
    value: String,
    onPasswordChange: (String) -> Unit,
    hasError: Boolean = false
) {
    var isPasswordVisible by remember {
        mutableStateOf(true)
    }
    OutlinedTextField(
        value = value,
        onValueChange = onPasswordChange,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        label = {
            Text(text = stringResource(id = R.string.password_field))
        },
        placeholder = {
            Text(text = stringResource(id = R.string.password_field))
        },
        visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            val icon = if (isPasswordVisible)
                R.drawable.baseline_visibility_off_24
                else R.drawable.baseline_visibility_24
            IconButton(
                onClick = {
                    isPasswordVisible = !isPasswordVisible
                }
            ) {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = stringResource(id = R.string.visibility),
                )
            }
        },
        isError = hasError,
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(50)
    )
}