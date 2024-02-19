package com.example.rideassistant.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.rideassistant.R

@Composable
fun EmailInput(
    email: String,
    onChangeText: (String) -> Unit,
    hasError: Boolean = false,
    isReadOnly: Boolean = false,
) {
    OutlinedTextField(
        value = email,
        onValueChange = onChangeText,
        modifier = Modifier
            .fillMaxWidth(),
        label = {
            Text(text = stringResource(id = R.string.email_field))
        },
        placeholder = {
            Text(text = stringResource(id = R.string.email_field))
        },
        shape = RoundedCornerShape(50),
        isError = hasError,
        singleLine = true,
        readOnly = isReadOnly,
    )
}