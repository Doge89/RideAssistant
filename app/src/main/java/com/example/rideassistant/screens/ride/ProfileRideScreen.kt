package com.example.rideassistant.screens.ride

import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.rideassistant.components.navigations.bottom.RideBottomNavigation
import java.security.Permissions

@Composable
fun ProfileRideScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier
            .background(Color.White),
        bottomBar = {
            RideBottomNavigation(navController = navController)
        }
    ) {paddingValues ->  
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            Text(text = "Profile")
        }
    }
}

fun askPermissions(context: Context) {
    ContextCompat.checkSelfPermission(context, ACCESS_COARSE_LOCATION)
}