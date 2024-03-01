package com.example.rideassistant.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.rideassistant.constants.PERMISSION_DENIED_ROUTE
import com.example.rideassistant.constants.RIDES_SCREEN_ROUTE
import com.example.rideassistant.controllers.auth.AuthController
import com.example.rideassistant.screens.login.LoginScreen
import com.example.rideassistant.screens.login.RegisterScreen
import com.example.rideassistant.screens.ride.IndexRideScreen
import com.example.rideassistant.screens.ride.ProfileRideScreen
import com.example.rideassistant.screens.utils.PermissionDeniedScreen
import com.example.rideassistant.screens.welcoming.WelcomingScreen
import kotlinx.coroutines.launch

@Composable
fun AppRouter() {
    val navController = rememberNavController()
    val authController = AuthController(appContext = LocalContext.current)
    LaunchedEffect(Unit) {
        if (authController.isUserAlreadySignedIn()) {
            navController.navigate(RIDES_SCREEN_ROUTE)
        }
    }
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
        navigation(startDestination = AppRouting.IndexScreen.route, route = PERMISSION_DENIED_ROUTE) {
            composable(route = AppRouting.IndexScreen.route) {
                PermissionDeniedScreen(navController = navController)
            }
        }
        navigation(startDestination = AppRouting.IndexScreen.route, route = RIDES_SCREEN_ROUTE) {
            composable(route = AppRouting.IndexScreen.route) {
                IndexRideScreen(navController = navController)
            }
            composable(route = AppRouting.ProfileScreen.route) {
                ProfileRideScreen(navController = navController)
            }
        }
    }
}

@Composable
inline fun <reified T: ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController): T {
    val navGraph = destination.parent?.route ?: return viewModel()
    val parent = remember(this) {
        navController.getBackStackEntry(navGraph)
    }
    return viewModel(parent)
}