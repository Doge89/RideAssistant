package com.example.rideassistant.screens.login

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.rideassistant.R
import com.example.rideassistant.navigation.AppRouting
import com.example.rideassistant.parcelables.Disability
import com.example.rideassistant.parcelables.RegisterParcelable
import com.example.rideassistant.viewmodels.auth.RegisterViewModel

@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = viewModel()
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        RegisterBody(navController = navController, registerViewModel =  registerViewModel)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RegisterBody(navController: NavController, registerViewModel: RegisterViewModel) {
    val registerState by registerViewModel.registerData.collectAsState()
    var userData by rememberSaveable {
        mutableStateOf(RegisterParcelable(
            username = "",
            phone = "",
            password = "",
            email = "",
            disabilities = listOf<Disability>(),
        ))
    }
    val pagerState = rememberPagerState(pageCount = {
        4
    })
    Column (
        modifier = Modifier
            .fillMaxSize(),
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxWidth(),
            state = pagerState,
        ) {
            when(it) {
                0 -> FormBasicData(
                    formData = userData,
                    onEmailChange = {registerParcelable ->
                        Log.d(Log.DEBUG.toString(), registerParcelable.toString())
                        userData = registerParcelable
                    }
                )
            }
        }

        Spacer(modifier = Modifier.padding(0.dp, 8.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                Log.d(Log.DEBUG.toString(), userData.toString())
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black,
            )
        ) {
            Text(
                modifier = Modifier
                    .padding(0.dp, 8.dp),
                text = "Registrarse",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                fontSize = TextUnit(21F, TextUnitType.Sp)
            )
        }
        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
        ) {
            Text(
                text = "¿Ya tienes cuenta?",
                fontWeight = FontWeight.Normal,
                fontSize = TextUnit(12F, TextUnitType.Sp),
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.padding(8.dp, 0.dp))
            Button(
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black,
                    containerColor = Color.White,
                ),
                contentPadding = PaddingValues(0.dp),
                shape = RoundedCornerShape(0),
                onClick = {
                    navController.navigate(AppRouting.LoginScreen.route)
                }
            ) {
                Text(
                    text = "Inicia sesión",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = TextUnit(12F, TextUnitType.Sp),
                )
            }
        }
    }
}

@Composable
fun FormBasicData(
    formData: RegisterParcelable,
    onEmailChange: (RegisterParcelable) -> Unit
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(50),
        value = formData.email,
        label = {
            Text(text = stringResource(id = R.string.email_field))
        },
        placeholder = {
            Text(text = stringResource(id = R.string.email_field))
        },
        onValueChange = {text ->
            onEmailChange(formData.copy(email = text))
        },
        singleLine = true,
    )
    Spacer(modifier = Modifier.padding(0.dp, 8.dp))
    OutlinedTextField(
        value = formData.username,
        onValueChange = {text ->
            formData.username = text
        }
    )
}