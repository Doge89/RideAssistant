package com.example.rideassistant.classes.validators

import android.util.Patterns
import com.example.rideassistant.constants.PASSWORD_PATTERN

/**
 * A set of functions to handle authentication validations*/
class AuthValidators : CoreValidator() {
    /**
     * Validate the input given, and check if can be a valid password
     * @param input The input to check
     * @return
     *  A true value if the input is a valid password*/
    fun validatePassword(input: String): Boolean {
        return PASSWORD_PATTERN.matches(input)
    }
}