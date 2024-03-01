package com.example.rideassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.rideassistant.navigation.AppRouter
import com.example.rideassistant.ui.theme.RideassistantTheme
import com.google.android.libraries.places.api.Places

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Places.initialize(applicationContext, "AIzaSyDfysX9E3NJCb8hSteP5OkPyIrA1fS9EFs")
        setContent {
            RideassistantTheme(
                dynamicColor = false
            ) {
                // A surface container using the 'background' color from the theme
                AppRouter()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RideAssistantPreview() {
    RideassistantTheme {
        AppRouter()
    }
}