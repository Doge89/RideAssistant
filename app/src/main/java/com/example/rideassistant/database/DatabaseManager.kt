package com.example.rideassistant.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.rideassistant.database.daos.DisabilityDao
import com.example.rideassistant.database.daos.UserDao
import com.example.rideassistant.database.entities.Disability
import com.example.rideassistant.database.entities.User

@Database(entities = [User::class, Disability::class], version = 1, exportSchema = false)
abstract class DatabaseManager: RoomDatabase() {
    abstract fun userDao(): UserDao

    abstract fun disabilityDao(): DisabilityDao
}