package com.example.myapp.models

import com.google.gson.annotations.SerializedName

data class RegistrationRequests(
    var name: String,
    @SerializedName("phone_number") var phoneNumber: String,
    var email: String,
    @SerializedName("date_of_birth") var dateOfBirth: String,
    var nationality: String,
    var password: String)
