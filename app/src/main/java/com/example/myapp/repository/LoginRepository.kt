package com.example.myapp.repository

import com.example.myapp.api.ApiClient
import com.example.myapp.api.ApiInterface
import com.example.myapp.models.LoginRequest
import com.example.myapp.models.LoginResponse
import retrofit2.Response
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class LoginRepository {
    private var apiInterface=ApiClient.buildApiClient(ApiInterface::class.java)
  suspend fun loginStudent(loginRequest: LoginRequest):Response<LoginResponse> =
   withContext(Dispatchers.IO){
       return@withContext apiInterface.loginStudent(loginRequest)
   }


}