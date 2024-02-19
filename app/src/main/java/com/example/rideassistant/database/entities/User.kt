package com.example.rideassistant.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Relation

@Entity(tableName = "user")
data class User (
    @PrimaryKey(autoGenerate = true) val idUser: Int,
    @ColumnInfo(index = true) val email: String,
    @ColumnInfo(index = true) var phone: String,
    @ColumnInfo var password: String,
    @ColumnInfo var name: String,
    @ColumnInfo var lastName: String,
    @ColumnInfo var isActive: Boolean,
    @ColumnInfo var isSignedIn: Boolean,
)

data class UserHasDisabilities (
    @Embedded val user: User,
    @Relation(
        parentColumn = "idUser",
        entityColumn = "idUser",
    )
    val disabilities: List<Disability>
)