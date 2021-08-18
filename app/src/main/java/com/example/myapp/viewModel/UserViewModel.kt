package com.example.myapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.models.RegistrationRequests
import com.example.myapp.models.RegistrationResponse
import com.example.myapp.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {
    var registrationLiveData=MutableLiveData<RegistrationResponse>()
     var regErrorLiveData=MutableLiveData<String>()
     var userRepository=UserRepository()

    fun registerStudent(registrationRequests: RegistrationRequests){
        viewModelScope.launch {
          val response=userRepository.registerStudent(registrationRequests)
            if (response.isSuccessful){
                registrationLiveData.postValue(response.body())

            }else{
                regErrorLiveData.postValue(response.errorBody()?.toString())
            }
        }
    }
}