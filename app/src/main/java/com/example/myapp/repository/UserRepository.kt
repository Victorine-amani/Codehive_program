package com.example.myapp.repository

import com.example.myapp.api.ApiClient
import com.example.myapp.api.ApiInterface
import com.example.myapp.models.RegistrationRequests
import com.example.myapp.models.RegistrationResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    private var apiInterface = ApiClient.buildApiClient(ApiInterface::class.java)
    suspend fun registerStudent(registrationRequests: RegistrationRequests): Response<RegistrationResponse> =
        withContext(Dispatchers.IO) {
            return@withContext apiInterface.registerStudent(registrationRequests)
        }
}