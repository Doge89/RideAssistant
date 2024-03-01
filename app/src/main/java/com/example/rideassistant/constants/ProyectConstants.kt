package com.example.rideassistant.constants

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.example.rideassistant.R
import com.example.rideassistant.classes.data.BottomNavigationButtonOptions
import com.example.rideassistant.classes.utils.UiText
import com.example.rideassistant.navigation.AppRouting

const val REGISTER_PAGER_PAGES = 3

val PASSWORD_PATTERN = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&])[A-Za-z\\d@\$!%*?&]{8,}\$")

const val DATABASE_NAME = "rideassistant"

const val RIDES_SCREEN_ROUTE = "ride"

const val PERMISSION_DENIED_ROUTE = "permission-denied"

val RIDE_BOTTOM_NAVIGATION: List<BottomNavigationButtonOptions> = arrayListOf(
    BottomNavigationButtonOptions(buttonText = "Inicio", icon = Icons.Default.Home, buttonRoute = AppRouting.IndexScreen.route),
    BottomNavigationButtonOptions(buttonText = "Perfil", icon = Icons.Default.Person, buttonRoute = AppRouting.ProfileScreen.route)
)

val FROM_REQUEST_CODE = 1
val TO_REQUEST_CODE = 2