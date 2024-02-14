package com.example.rideassistant.controllers.auth

/**
 * Holds a set of basic functions to authenticate the user in the app*/
class AuthController() {

    private lateinit var username: String

    constructor(username: String) : this() {
        this.username = username;
    }

    fun registerUser() {

    }
}

val auth = AuthController("undertale.9055@gmail.com");