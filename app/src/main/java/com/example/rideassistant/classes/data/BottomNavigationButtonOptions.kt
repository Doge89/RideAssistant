package com.example.rideassistant.classes.data

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationButtonOptions (
    val buttonText: String,
    val modifier: Modifier? = Modifier,
    val icon: ImageVector? = null,
    val description: String? = "",
    val buttonRoute: String? = "",
)