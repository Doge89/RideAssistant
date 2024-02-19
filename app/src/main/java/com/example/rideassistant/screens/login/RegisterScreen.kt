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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.rideassistant.R
import com.example.rideassistant.classes.data.SimpleListData
import com.example.rideassistant.components.buttons.PrimaryButton
import com.example.rideassistant.components.inputs.EmailInput
import com.example.rideassistant.components.inputs.PasswordInput
import com.example.rideassistant.components.inputs.PhoneInput
import com.example.rideassistant.components.inputs.TextInput
import com.example.rideassistant.components.lists.SimpleList
import com.example.rideassistant.navigation.AppRouting
import com.example.rideassistant.parcelables.Disability
import com.example.rideassistant.parcelables.RegisterParcelable
import com.example.rideassistant.viewmodels.auth.RegisterViewModel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun RegisterScreen(
    navController: NavController,
    registerViewModel: RegisterViewModel = viewModel()
) {
        Column (
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            RegisterBody(navController = navController, registerViewModel =  registerViewModel)
        }
}

@OptIn(ExperimentalFoundationApi::class, ExperimentalComposeUiApi::class)
@Composable
fun RegisterBody(navController: NavController, registerViewModel: RegisterViewModel) {
    val registerState by registerViewModel.registerData.collectAsState()
    val hasAllDataFilled by registerViewModel.hasAllTheData.collectAsState()
    val disabilities by registerViewModel.disabilities.collectAsState()
    val pagerState = rememberPagerState(pageCount = {
        4
    })
    val keyboardController = LocalSoftwareKeyboardController.current
    val coroutineScope = rememberCoroutineScope()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
    ) {
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .fillMaxSize()
                .weight(1F, false),
            verticalAlignment = Alignment.Top,
            state = pagerState,
            userScrollEnabled = false,
        ) {
            when(it) {
                0 -> FormBasicData(
                    formData = registerState,
                    onEmailChange = {newEmailValue ->
                        Log.d(Log.DEBUG.toString(), newEmailValue)
                        registerViewModel.changeRegisterUserData(
                            registerState.copy(email = newEmailValue),
                        )
                    },
                    onPhoneChange = {newPhoneValue ->
                        registerViewModel.changeRegisterUserData(
                            registerState.copy(phone = newPhoneValue)
                        )
                    },
                    onNameChange = {newNameValue ->
                        registerViewModel.changeRegisterUserData(
                            registerState.copy(name = newNameValue)
                        )
                    },
                    onLastNameChange = {newLastNameValue ->
                        registerViewModel.changeRegisterUserData(
                            registerState.copy(lastName = newLastNameValue)
                        )
                    }
                )
                1 -> FormDisabilities(
                        disabilities = disabilities,
                        onInsertDisability = {disability ->
                            registerViewModel.addDisability(disability)
                            keyboardController?.hide()
                        },
                    )
                2 -> FormPassword(
                    onSetPassword = {
                        registerViewModel.changeRegisterUserData(
                            registerState.copy(password = it)
                        )
                    },
                )
            }
        }
        Spacer(modifier = Modifier.padding(0.dp, 8.dp))
        Button(
            modifier = Modifier
                .fillMaxWidth(),
            onClick = {
                coroutineScope.launch {
                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                }
            },
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.White,
                containerColor = Color.Black,
            )
        ) {
            Text(
                modifier = Modifier
                    .padding(0.dp, 8.dp),
                text = stringResource(id = if (hasAllDataFilled) R.string.register else R.string.next),
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
    onEmailChange: (String) -> Unit,
    onPhoneChange: (String) -> Unit,
    onNameChange: (String) -> Unit,
    onLastNameChange: (String) -> Unit
) {
    Column {
        Text(
            text = stringResource(id = R.string.basic_data),
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(28F, TextUnitType.Sp)
        )
        Spacer(modifier = Modifier.padding(0.dp, 2.dp))
        Text(
            text = stringResource(id = R.string.basic_data_section),
            fontWeight = FontWeight.Normal,
            fontSize = TextUnit(16F, TextUnitType.Sp),
            style = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 1.em
                )
            ),
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        EmailInput(
            email = formData.email,
            onChangeText = onEmailChange,
        )
        Spacer(modifier = Modifier.padding(0.dp, 8.dp))
        PhoneInput(
            phone = formData.phone,
            onPhoneChange = onPhoneChange,
        )
        Spacer(modifier = Modifier.padding(0.dp, 8.dp))
        TextInput(
            text = formData.name,
            onInputChange = onNameChange,
            label = {
                Text(text = stringResource(id = R.string.name_field))
            },
            placeholder = {
                Text(text = stringResource(id = R.string.name_field))
            },
            isSingleLine = true
        )
        Spacer(modifier = Modifier.padding(0.dp, 8.dp))
        TextInput(
            text = formData.lastName,
            onInputChange = onLastNameChange,
            label = {
                Text(text = stringResource(id = R.string.last_name_field))
            },
            placeholder = {
                Text(text = stringResource(id = R.string.last_name_field))
            },
            isSingleLine = true
        )
    }
}

@Composable
fun FormDisabilities(
    disabilities: List<Disability>,
    onInsertDisability: (Disability) -> Unit,
) {
    var disability by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    Column {
        Text(
            text = stringResource(id = R.string.disability_field),
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(28F, TextUnitType.Sp),
        )
        Spacer(modifier = Modifier.padding(0.dp, 2.dp))
        Text(
            text = stringResource(id = R.string.disability_data_section),
            fontWeight = FontWeight.Normal,
            fontSize = TextUnit(16F, TextUnitType.Sp),
            color = Color.DarkGray,
            style = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 1.em
                )
            )
        )
        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextInput(
                text = disability,
                onInputChange = {text ->
                    disability = text
                },
                isSingleLine = true,
                label = {
                    Text(text = stringResource(id = R.string.disability_field))
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.disability_field))
                }
            )
            Spacer(modifier = Modifier.padding(0.dp, 8.dp))
            TextInput(
                text = description,
                onInputChange = {text -> 
                    description = text
                },
                isSingleLine = false,
                label = {
                    Text(text = stringResource(id = R.string.description_field))
                },
                placeholder = {
                    Text(text = stringResource(id = R.string.description_field))
                }
            )
            Spacer(modifier = Modifier.padding(0.dp, 4.dp))
            PrimaryButton(
                onClick = {
                    Log.d(Log.DEBUG.toString(), "$disability: $description")
                    onInsertDisability(
                        Disability(disability = disability, description = description)
                    )
                    disability = ""
                    description = ""
                },
                shape = CircleShape,
                modifier = Modifier
                    .size(75.dp),
                buttonText = {
                    Icon(
                        Icons.Default.Add,
                        contentDescription = stringResource(id = R.string.add),
                    )
                }
            )
        }
        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        Column {
            SimpleList(data = disabilities.map { SimpleListData(it.disability, it.description) })
        }
    }
}

@Composable
fun FormPassword(
    onSetPassword: (String) -> Unit,
) {
    var password by remember {
        mutableStateOf("")
    }
    Column {
        Text(
            text = stringResource(id = R.string.password_field),
            fontWeight = FontWeight.Bold,
            fontSize = TextUnit(28F, TextUnitType.Sp),
        )
        Spacer(modifier = Modifier.padding(0.dp, 2.dp))
        Text(
            text = stringResource(id = R.string.password_section),
            fontWeight = FontWeight.Normal,
            fontSize = TextUnit(16F, TextUnitType.Sp),
            color = Color.DarkGray,
            style = LocalTextStyle.current.merge(
                TextStyle(
                    lineHeight = 1.em
                )
            )
        )
        Spacer(modifier = Modifier.padding(0.dp, 16.dp))
        PasswordInput(
            value = password,
            onPasswordChange = {
                password = it
            }
        )
    }
}