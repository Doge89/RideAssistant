package com.example.rideassistant.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rideassistant.R
import com.example.rideassistant.navigation.AppRouting

@Composable
fun LoginScreen(navController: NavController) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Body(navController = navController)
    }
}

@Composable
fun Body(navController: NavController, modifier: Modifier = Modifier) {
    var username by remember {
        mutableStateOf("")
    }
    var password by remember {
        mutableStateOf("")
    }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier
                .width(128.dp)
                .height(128.dp),
            painter = painterResource(id = R.drawable.logo_ride_svg_64x64),
            contentDescription = "Logo de la aplicación",
        )
        Spacer(modifier = Modifier.padding(0.dp, 32.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            label = {
                Text(text = "Correo o teléfono")
            },
            placeholder = {
                Text(text = "Ingrese un correo o teléfono valido")
            },
            value = username,
            onValueChange = { text ->
                username = text
            },
            shape = RoundedCornerShape(50),
            singleLine = true
        )
        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = password,
            label = {
                Text(text = "Contraseña")
            },
            placeholder = {
                Text(text = "Ingrese su contraseña")
            },
            onValueChange = {text ->
                password = text
            },
            shape = RoundedCornerShape(50),
            singleLine = true,
        )
        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Button(
                modifier = Modifier
                    .fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White,
                ),
                onClick = {

                }
            ) {
                Text(
                    modifier = Modifier
                        .padding(0.dp, 8.dp),
                    text = "Iniciar sesión",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = TextUnit(21F, TextUnitType.Sp)
                )
            }
            Spacer(modifier = Modifier.padding(0.dp, 8.dp))
            Row (
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "¿No tienes una cuenta?",
                    color = Color.LightGray,
                    fontWeight = FontWeight.Normal,
                    fontSize = TextUnit(12F, TextUnitType.Sp)
                )
                Spacer(modifier = Modifier.padding(8.dp, 0.dp))
                Button(
                    onClick = {
                        navController.navigate(AppRouting.RegisterScreen.route)
                    },
                    shape = RoundedCornerShape(0),
                    contentPadding = PaddingValues(0.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black,
                        containerColor = Color.White,
                    )
                ) {
                    Text(
                        text = "¡Registrate aquí!",
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = TextUnit(12F, TextUnitType.Sp)
                    )
                }
            }
        }
    }
}