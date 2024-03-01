package com.example.rideassistant.components.buttons

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.rideassistant.classes.data.BottomNavigationButtonOptions

@Composable
fun BottomNavigationButton(
    onClick: () -> Unit,
    options: BottomNavigationButtonOptions,
) {
    PrimaryButton(
        buttonText = {
            Column {
                if (options.icon != null) {
                    Icon(options.icon, contentDescription = options.description ?: "")
                    Spacer(modifier = Modifier.padding(0.dp, 4.dp))
                }
                Text(text = options.buttonText)
            }
        },
        onClick = onClick,
        shape = RoundedCornerShape(0)
    )    
}