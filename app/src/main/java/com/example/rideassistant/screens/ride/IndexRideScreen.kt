package com.example.rideassistant.screens.ride

import android.Manifest
import android.Manifest.permission.ACCESS_COARSE_LOCATION
import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.util.Log
import android.widget.AutoCompleteTextView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.navigation.NavController
import com.example.rideassistant.components.inputs.SearchInputPlaces
import com.example.rideassistant.components.navigations.bottom.RideBottomNavigation
import com.example.rideassistant.constants.PERMISSION_DENIED_ROUTE
import com.example.rideassistant.constants.RIDES_SCREEN_ROUTE
import com.example.rideassistant.utils.permissions.requestPermission
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.model.Place
import com.google.android.libraries.places.widget.Autocomplete
import com.google.android.libraries.places.widget.AutocompleteActivity
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import com.google.maps.android.compose.MarkerInfoWindow
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun IndexRideScreen(navController: NavController) {
    val currContext = LocalContext.current
    if (ActivityCompat.checkSelfPermission(currContext, ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
        val launcher = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.RequestPermission(),
            onResult = {isGranted ->
                navController.navigate(if (isGranted) RIDES_SCREEN_ROUTE else PERMISSION_DENIED_ROUTE)
            }
        )
        SideEffect {
            launcher.launch(ACCESS_FINE_LOCATION)
        }
    }
    val locationProviderClient = remember {
        LocationServices.getFusedLocationProviderClient(currContext)
    }
    var lastKnownLocation by remember {
        mutableStateOf<Location?>(null)
    }
    var deviceLatLng by remember {
        mutableStateOf(LatLng(0.0, 0.0))
    }
    var cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(deviceLatLng, 18F)
    }
    val locationResult = locationProviderClient.lastLocation
    locationResult.addOnCompleteListener {task ->
        if (task.isSuccessful) {
            lastKnownLocation = task.result
            deviceLatLng = LatLng(lastKnownLocation!!.latitude, lastKnownLocation!!.longitude)
            cameraPositionState.position = CameraPosition.fromLatLngZoom(deviceLatLng, 18F)
        } else {
            Log.d("DEBUG", "Current location is null. Using Defaults")
            Log.e("DEBUG", "Exception: %s", task.exception)
        }
    }
    Scaffold(
        containerColor = Color.White,
        bottomBar = {
            RideBottomNavigation(navController = navController)
        }
    ) {paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
        ) {
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Transparent)
                    .clickable {

                        currContext.startActivity(prepareAutocompleteIntent(context = currContext))
                    }
            ) {
                SearchInputPlaces(onClickResult = {})
            }
            GoogleMap (
                cameraPositionState = cameraPositionState,
                uiSettings = MapUiSettings(
                    myLocationButtonEnabled = true,
                    zoomControlsEnabled = true,
                    zoomGesturesEnabled = true,
                    rotationGesturesEnabled = true,
                    compassEnabled = true,
                )
            ) {
                MarkerInfoWindow (
                    state = MarkerState(position = deviceLatLng)
                ) {marker ->
                    Text(text = marker.title ?: "You", color = Color.Red)
                }
            }
        }
    }
}

fun prepareAutocompleteIntent(context: Context): Intent {
    val fields = listOf<Place.Field>(Place.Field.ID, Place.Field.NAME)
    return Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields).build(context)
}