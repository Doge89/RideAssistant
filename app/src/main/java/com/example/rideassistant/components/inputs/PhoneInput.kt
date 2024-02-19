package com.example.rideassistant.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import com.example.rideassistant.R

@Composable
fun PhoneInput(
    phone: String,
    onPhoneChange: (String) -> Unit,
    hasError: Boolean = false,
    isReadOnly: Boolean = false,
) {
    OutlinedTextField(
        value = phone,
        onValueChange = onPhoneChange,
        modifier = Modifier
            .fillMaxWidth(),
        isError = hasError,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
        label = {
            Text(text = stringResource(id = R.string.phone_field))
        },
        placeholder = {
            Text(text = stringResource(id = R.string.phone_field))
        },
        readOnly = isReadOnly,
        shape = RoundedCornerShape(50)
    )
}