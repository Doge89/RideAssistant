package com.example.rideassistant.controllers.auth

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.rideassistant.classes.validators.AuthValidators
import com.example.rideassistant.constants.DATABASE_NAME
import com.example.rideassistant.database.DatabaseManager
import com.example.rideassistant.database.entities.User
import com.example.rideassistant.database.entities.UserDto
import com.example.rideassistant.parcelables.RegisterParcelable

/**
 * Holds a set of basic functions to authenticate the user in the app*/
class AuthController(private val _coreValidator: AuthValidators) {

    private lateinit var _context: Context
    private lateinit var _userData: RegisterParcelable
    private lateinit var _db: DatabaseManager

    constructor(appContext: Context,userData: RegisterParcelable) : this(AuthValidators()) {
        this._context = appContext
        this._userData = userData;
        this._db = Room.databaseBuilder(
            this._context,
            DatabaseManager::class.java,
            DATABASE_NAME
        ).build()
    }

    constructor(appContext: Context): this(AuthValidators()) {
        this._context = appContext
        this._db = Room.databaseBuilder(
            this._context,
            DatabaseManager::class.java,
            DATABASE_NAME,
        ).build()
    }

    /**
     * Check if the first part of the form is valid
     * @return
     *  A true value if the object is valid otherwise false*/
    suspend fun validateBasicData(): Boolean {
        if (!this._coreValidator.isValidString(this._userData.name)) return false
        if (!this._coreValidator.isValidString(this._userData.lastName)) return false;
        if (!this._coreValidator.isValidEmail(this._userData.email)) return false;
        if (this.userExistsAlready(_userData.email)) return false
        return this._coreValidator.isPhoneValid(_userData.phone)
    }

    fun validatePasswordForm(): Boolean {
        Log.d("DEBUG", this._userData.password)
        Log.d("DEBUG", this._coreValidator.validatePassword(_userData.password).toString())
        return this._coreValidator.validatePassword(_userData.password)
    }

    /**
     * Check in the database if the user with that email already exists
     * @param email The user to check if exists
     * @return
     *  A true value if the user already exists*/
    suspend fun userExistsAlready(email: String): Boolean {
        val userDao = this._db.userDao()
        val user = userDao.getUserByEmail(email)
        return user != null
    }

    /**
     * Create a new user in the database
     * */
    suspend fun createUser(): Unit {
        val usersDao = this._db.userDao()
        usersDao.insertUser(
            UserDto(
                name = _userData.name,
                password = _userData.password,
                lastName =  _userData.lastName,
                phone = _userData.phone,
                email = _userData.email,
            )
        )
    }

    /**
     * Get the user signed in
     * @return
     *  All the data related with the user signed in*/
    suspend fun getUserSignedIn(): User {
        return this._db.userDao().getUserSignedIn()
    }

    /**
     * Check if exists a user signed in
     * @return
     *  A boolean value, true if a users is already signed in*/
    suspend fun isUserAlreadySignedIn(): Boolean {
        val userDao = this._db.userDao()
        val user = userDao.getUserSignedIn()
        return user != null
    }
}