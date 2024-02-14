package com.example.rideassistant.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.rideassistant.database.entities.Disability
import com.example.rideassistant.database.entities.UserHasDisabilities

@Dao
interface DisabilityDao {

    @Query("SELECT DISTINCT * FROM disability")
    fun getAllDisabilities(): List<Disability>

    @Query(
        "SELECT * FROM disability AS d, user AS u WHERE d.idUser = :idUser AND u.idUser = :idUser"
    )
    fun getUserDisabilities(idUser: Int): UserHasDisabilities

    @Insert
    fun insertDisability(vararg data: Disability)

}