package com.example.rideassistant.controllers.auth

import com.example.rideassistant.classes.validators.CoreValidator
import com.example.rideassistant.parcelables.RegisterParcelable

/**
 * Holds a set of basic functions to authenticate the user in the app*/
class AuthController(private val _coreValidator: CoreValidator) {

    private lateinit var _userData: RegisterParcelable

    constructor(userData: RegisterParcelable) : this(CoreValidator()) {
        this._userData = userData;
    }

    /**
     * Check if the first part of the form is valid
     * @return
     *  A true value if the object is valid otherwise false*/
    fun validateBasicData(): Boolean {

    }
}