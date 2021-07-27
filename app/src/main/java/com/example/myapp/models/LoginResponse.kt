package com.example.myapp.models

data class LoginResponse(
    var message: String,
    var accessToken: String,
    var studentId: String
)
