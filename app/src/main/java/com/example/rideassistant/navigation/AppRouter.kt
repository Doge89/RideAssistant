package com.example.rideassistant.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.rideassistant.screens.login.LoginScreen
import com.example.rideassistant.screens.login.RegisterScreen
import com.example.rideassistant.screens.welcoming.WelcomingScreen

@Composable
fun AppRouter() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppRouting.WelcomingScreen.route) {
        composable(route = AppRouting.WelcomingScreen.route) {
            WelcomingScreen(navController = navController)
        }
        composable(route = AppRouting.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(route = AppRouting.RegisterScreen.route) {
            RegisterScreen(navController = navController)
        }
    }
}