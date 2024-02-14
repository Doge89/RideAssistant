package com.example.rideassistant.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import androidx.room.Query
import androidx.room.Transaction
import com.example.rideassistant.database.entities.User
import com.example.rideassistant.database.entities.UserHasDisabilities

@Dao
interface UserDao {
    @Transaction
    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>

    @Transaction
    @Query("SELECT * FROM user WHERE phone = :phone LIMIT 1")
    fun getUserByPhone(phone: String): User

    @Transaction
    @Query("SELECT * FROM user WHERE idUser = :idUser LIMIT 1")
    fun getUserWithDisabilities(idUser: Int): UserHasDisabilities

    @Insert
    fun insertUser(vararg userData: User)
}