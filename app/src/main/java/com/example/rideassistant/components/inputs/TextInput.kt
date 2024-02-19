package com.example.rideassistant.components.inputs

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.rideassistant.R

@Composable
fun TextInput (
    text: String,
    onInputChange: (String) -> Unit,
    hasError: Boolean = false,
    isReadOnly: Boolean = false,
    isSingleLine: Boolean = false,
    label: @Composable (() -> Unit)? = {},
    placeholder: @Composable (() -> Unit)? = {}
) {
    OutlinedTextField(
        value = text,
        onValueChange = onInputChange,
        label = label,
        placeholder = placeholder,
        readOnly = isReadOnly,
        singleLine = isSingleLine,
        isError = hasError,
        shape = RoundedCornerShape(50),
        modifier = Modifier
            .fillMaxWidth()
    )
}