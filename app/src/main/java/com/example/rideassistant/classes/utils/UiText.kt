package com.example.rideassistant.classes.utils

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class UiText {
    data class ToString(val value: String): UiText()

    class StringResource(
        @StringRes val id: Int,
        vararg val args: Any
    ): UiText()

    @Composable
    fun asString(): String {
        return when (this) {
            is ToString -> value
            is StringResource -> stringResource(id = id, *args)
        }
    }
}