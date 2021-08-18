package com.example.myapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.models.LoginRequest
import com.example.myapp.models.LoginResponse
import com.example.myapp.repository.LoginRepository
import kotlinx.coroutines.launch

class LoginViewModel:ViewModel() {
    var loginLiveData= MutableLiveData<LoginResponse>()
    var logErrorLiveData=MutableLiveData<String>()
    var loginRepository=LoginRepository()
    fun loginStudent(loginRequest: LoginRequest){
        viewModelScope.launch {
       val  response=loginRepository.loginStudent(loginRequest)
       if (response.isSuccessful){
           loginLiveData.postValue(response.body())
       }else{
           logErrorLiveData.postValue(response.errorBody()?.toString())
       }
        }
    }
}