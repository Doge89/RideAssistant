package com.example.rideassistant.utils.permissions

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.rideassistant.constants.PERMISSION_DENIED_ROUTE
import com.example.rideassistant.constants.RIDES_SCREEN_ROUTE

/**
 * Request to the user the given permission
 * @param context The context where the user will be requested
 * @param permission Which will be the permission to ask
 * @return
 *  A boolean value indicating if the user consent the requested permission*/
@Composable
fun requestPermission(context: Context, permission: String, navController: NavController): Boolean {
    if (ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED) {
        return true
    } else {
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = {isGranted ->
                navController.navigate(if (isGranted) RIDES_SCREEN_ROUTE else PERMISSION_DENIED_ROUTE)
            }
        )
        SideEffect {
            launcher.launch(Manifest.permission.ACCESS_FINE_LOCATION)
        }
    }
    return ContextCompat.checkSelfPermission(context, permission) == PackageManager.PERMISSION_GRANTED
}