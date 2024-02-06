package com.example.rideassistant.navigation

sealed class AppRouting(val route: String) {
    object WelcomingScreen: AppRouting("welcoming")
    object LoginScreen: AppRouting("login")
    object RegisterScreen: AppRouting("register")
}