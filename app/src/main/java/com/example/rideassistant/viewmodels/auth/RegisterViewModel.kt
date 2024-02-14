package com.example.rideassistant.viewmodels.auth

import androidx.lifecycle.ViewModel
import com.example.rideassistant.parcelables.Disability

import com.example.rideassistant.parcelables.RegisterParcelable
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel: ViewModel() {
    private val _registerData = MutableStateFlow(
        RegisterParcelable(
        username = "",
        email = "",
        disabilities = listOf<Disability>(),
        password =  "",
        phone = ""
    ))
    val registerData: StateFlow<RegisterParcelable> = this._registerData.asStateFlow()

    fun changeRegisterUserData(
        username: String?,
        email: String?,
        disability: Disability,
        password: String?,
        phone: String?
    ) {
        this._registerData.update { currState ->
            val disList = mutableListOf<Disability>()
            currState.disabilities.forEach { disability ->
                disList.add(disability)
            }
            disList.add(disability)
            currState.copy(
                username = username ?: currState.username,
                email = email ?: currState.email,
                disabilities = disList.toList(),
                password = password ?: currState.password,
                phone = phone ?: currState.phone
            )
        }
    }
}