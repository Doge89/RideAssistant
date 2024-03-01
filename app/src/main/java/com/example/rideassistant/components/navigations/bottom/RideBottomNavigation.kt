package com.example.rideassistant.components.navigations.bottom

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rideassistant.classes.data.BottomNavigationButtonOptions
import com.example.rideassistant.components.buttons.BottomNavigationButton
import com.example.rideassistant.components.buttons.PrimaryButton
import com.example.rideassistant.constants.RIDE_BOTTOM_NAVIGATION
import com.example.rideassistant.navigation.AppRouting

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun RideBottomNavigation(navController: NavController) {
    val currRoute by navController.currentBackStackEntryAsState()
    val route = currRoute?.destination?.route
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        RIDE_BOTTOM_NAVIGATION.forEach {option ->
            BottomNavigationButton(
                onClick = {
                    navController.navigate(option.buttonRoute ?: "")
                },
                options = BottomNavigationButtonOptions(buttonText = option.buttonText, icon = option.icon),
            )
        }
    }
}