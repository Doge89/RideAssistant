package com.example.rideassistant.viewmodels.rides

import android.location.Location
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RidesViewModel: ViewModel() {

    val _currLocation = MutableStateFlow(Location(null))

    val currLocation: StateFlow<Location> = _currLocation.asStateFlow()

}