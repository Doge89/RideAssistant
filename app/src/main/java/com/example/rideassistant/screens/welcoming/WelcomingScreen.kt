package com.example.rideassistant.screens.welcoming

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rideassistant.R
import com.example.rideassistant.navigation.AppRouting

@Composable
fun WelcomingScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Body(navController = navController)
    }
}

@Composable
fun Body(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.undraw_order_ride_re_372k),
            contentDescription = "Una persona que esta solicitó un automóvil",
            modifier = Modifier
        )
        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        Text(
            text = "Empieza a viajar de forma segura y con ayuda personalizada",
            textAlign = TextAlign.Center,
        )
        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black,
                contentColor = Color.White,
            ),
            onClick = {
                navController.navigate(AppRouting.RegisterScreen.route)
            }
        ) {
            Text(
                modifier = Modifier
                    .padding(0.dp, 8.dp),
                text = "Empieza a viajar",
                fontSize = TextUnit(21F, TextUnitType.Sp),
                fontWeight = FontWeight.SemiBold,
            )
        }
        Spacer(modifier = Modifier.padding(0.dp, 8.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = Color.Black,
            ),
            onClick = {
                navController.navigate(AppRouting.LoginScreen.route)
            }
        ) {
            Text(
                modifier = Modifier
                    .padding(0.dp, 8.dp),
                text = "Iniciar sesión",
                fontWeight = FontWeight.SemiBold,
                fontSize = TextUnit(21F, TextUnitType.Sp),
                textAlign = TextAlign.Center
            )
        }
    }
}
