package com.example.rideassistant.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "disability", foreignKeys = [
    ForeignKey(
        entity = User::class,
        parentColumns = ["idUser"],
        childColumns = ["idUser"],
        onDelete = ForeignKey.RESTRICT,
    ),
])
data class Disability(
    @PrimaryKey(autoGenerate = true) val idDisability: Int,
    @ColumnInfo(index = true) val disability: String,
    @ColumnInfo val description: String,
    @ColumnInfo(index = true) val idUser: Int
)