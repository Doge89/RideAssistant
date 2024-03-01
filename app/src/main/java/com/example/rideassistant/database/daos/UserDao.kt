package com.example.rideassistant.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Query
import androidx.room.Transaction
import com.example.rideassistant.database.entities.User
import com.example.rideassistant.database.entities.UserDto
import com.example.rideassistant.database.entities.UserHasDisabilities

@Dao
interface UserDao {
    @Transaction
    @Query("SELECT * FROM user")
    suspend fun getAllUsers(): List<User>

    @Transaction
    @Query("SELECT * FROM user WHERE phone = :phone LIMIT 1")
    suspend fun getUserByPhone(phone: String): User

    @Transaction
    @Query("SELECT * FROM user WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): User

    @Transaction
    @Query("SELECT * FROM user WHERE idUser = :idUser LIMIT 1")
    suspend fun getUserWithDisabilities(idUser: Int): UserHasDisabilities

    @Transaction
    @Query("SELECT * FROM user WHERE isSignedIn = 1 LIMIT 1")
    suspend fun getUserSignedIn(): User

    @Insert(entity = User::class)
    suspend fun insertUser(vararg userData: UserDto)
}