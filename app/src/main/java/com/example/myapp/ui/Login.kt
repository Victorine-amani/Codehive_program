package com.example.myapp.ui

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.R
import com.example.myapp.databinding.ActivityLoginBinding
import com.example.myapp.models.LoginRequest
import com.example.myapp.viewModel.LoginViewModel

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences=getSharedPreferences("CODEHIVE_REG_PREFS", Context.MODE_PRIVATE)
        binding.btnLogin.setOnClickListener {
           var logInRequest=LoginRequest(binding.etEmail.text.toString(),
               binding.etPassword.text.toString())
            loginViewModel.loginStudent(logInRequest)

        }

    }

    override fun onResume() {
        super.onResume()
        loginViewModel.loginLiveData.observe(this, {loginResponse->
            Toast.makeText(baseContext, loginResponse.message, Toast.LENGTH_LONG).show()
            var accessToken=loginResponse.accessToken
            sharedPreferences.edit().putString("ACCESS_TOKEN", accessToken).apply()
            var shared=sharedPreferences.getString("ACCESS_TOKEN","")
        })
       loginViewModel.logErrorLiveData.observe(this,{error->
        Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
    })

    }

  }

