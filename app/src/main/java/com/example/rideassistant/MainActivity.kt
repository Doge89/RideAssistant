package com.example.rideassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.rideassistant.navigation.AppRouter
import com.example.rideassistant.ui.theme.RideassistantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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