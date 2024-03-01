package com.example.rideassistant.navigation

sealed class AppRouting(val route: String) {
    object WelcomingScreen: AppRouting("welcoming")
    object LoginScreen: AppRouting("login")
    object RegisterScreen: AppRouting("register")
    data object IndexScreen: AppRouting("index")
    data object ProfileScreen: AppRouting("profile")

}