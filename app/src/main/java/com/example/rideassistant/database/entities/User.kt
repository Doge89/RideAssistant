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
    @ColumnInfo(index = true) val phone: String,
    @ColumnInfo val password: String,
    @ColumnInfo val name: String,
    @ColumnInfo val lastName: String,
    @ColumnInfo val isActive: Boolean,
)

data class UserHasDisabilities (
    @Embedded val user: User,
    @Relation(
        parentColumn = "idUser",
        entityColumn = "idUser",
    )
    val disabilities: List<Disability>
)