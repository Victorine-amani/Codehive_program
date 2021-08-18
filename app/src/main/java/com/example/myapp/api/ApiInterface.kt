package com.example.myapp.api

import com.example.myapp.models.LoginRequest
import com.example.myapp.models.LoginResponse
import com.example.myapp.models.RegistrationRequests
import com.example.myapp.models.RegistrationResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Content-Type: application/json")
    @POST("/students/register")
    suspend fun registerStudent(@Body registrationRequests: RegistrationRequests):Response<RegistrationResponse>

    @POST("/students/login")
    suspend fun loginStudent(@Body logInRequest: LoginRequest): Response<LoginResponse>
}