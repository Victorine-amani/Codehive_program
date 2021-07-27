package com.example.myapp.Api

import com.example.myapp.models.LoginRequest
import com.example.myapp.models.LoginResponse
import com.example.myapp.models.RegistrationRequests
import com.example.myapp.models.RegistrationResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {
    @Headers("Content-Type: application/json")
    @POST("/students/register")
    fun register(@Body registrationRequests: RegistrationRequests):Call<RegistrationResponse>

    @POST("/students/login")
    fun loginStudent(@Body logInRequest: LoginRequest): Call<LoginResponse>
}