package com.example.rideassistant.classes.validators

import android.util.Patterns

/**
 * This class contains all the core validations to apply*/
class CoreValidator {
    /**
     * Check if a string is valid
     * @param input The string to check
     * @return True if the string is valid*/
    fun isValidString(input: String): Boolean {
        return input.isNotBlank()
    }

    /**
     * Check if the string is valid to be an Email
     * @param input The string to check
     * @return
     *  True if the string is a valid email*/
    fun isValidEmail(input: String): Boolean {
        if (!this.isValidString(input)) return false
        return Patterns.EMAIL_ADDRESS.matcher(input).matches()
    }
}