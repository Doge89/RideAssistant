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
        name = "",
        lastName = "",
        email = "",
        disabilities = listOf<Disability>(),
        password =  "",
        phone = ""
    ))
    val registerData: StateFlow<RegisterParcelable> = this._registerData.asStateFlow()

    private val _disabilities = MutableStateFlow(mutableListOf<Disability>())
    val disabilities: StateFlow<MutableList<Disability>> = this._disabilities.asStateFlow()

    private val _hasAllTheData = MutableStateFlow(false)
    val hasAllTheData: StateFlow<Boolean> = _hasAllTheData.asStateFlow()

    fun changeRegisterUserData(
        registerUserData: RegisterParcelable
    ) {
        _registerData.value = registerUserData
    }

    fun addDisability(disability: Disability) {
        val disabilityCopy = this._disabilities.value
        disabilityCopy.add(disability)
        _disabilities.value = disabilityCopy
    }

}