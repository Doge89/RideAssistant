package com.example.rideassistant.screens.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rideassistant.R

@Composable
fun PermissionDeniedScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.access_denied),
            contentDescription = stringResource(id = R.string.access_denied),
        )
        Spacer(modifier = Modifier.padding(0.dp, 24.dp))
        Text(
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            text = stringResource(id = R.string.permission_denied),
            fontSize = TextUnit(21F, TextUnitType.Sp),
        )
    }
}