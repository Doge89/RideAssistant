package com.example.rideassistant.parcelables

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Disability(
    var disability: String,
    var description: String,
): Parcelable

@Parcelize
data class RegisterParcelable(
    var username: String,
    var phone: String,
    var password: String,
    var email: String,
    var disabilities: List<Disability>,
): Parcelable