package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.myapp.Api.ApiClient
import com.example.myapp.Api.ApiInterface
import com.example.myapp.models.LoginRequest
import com.example.myapp.models.LoginResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password: EditText
    lateinit var btn1: Button
    lateinit var btn2: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        cast()
var barua=email.text.toString()
        var secure=password.text.toString()
        btn1.setOnClickListener {
            if (barua.isEmpty()) {
                email.setError("fill in all fields")
            }

            if (secure.isEmpty()) {
                password.setError("Fill in all fields")
                val loginRequest = LoginRequest(
                    email = barua,
                    password = secure
                )

                val retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
                var request = retrofit.loginStudent(loginRequest)
                request.enqueue(object : Callback<LoginResponse?> {
                    override fun onResponse(
                        call: Call<LoginResponse?>,
                        response: Response<LoginResponse?>
                    ) {
                        if (response.isSuccessful) {
                            Toast.makeText(baseContext, "Login Successful", Toast.LENGTH_LONG)
                                .show()
                            var intent = Intent(baseContext, CoursesActivity::class.java)
                            startActivity(intent)
                        } else {
                            try {
                                val error = JSONObject(response.errorBody()!!.string())
                                Toast.makeText(baseContext, error.toString(), Toast.LENGTH_LONG)
                                    .show()
                            } catch (e: Exception) {
                                Toast.makeText(baseContext, e.message, Toast.LENGTH_LONG).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse?>, t: Throwable) {
                        Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
                    }
                })


            }
        }


        btn2.setOnClickListener {
            var intent = Intent(baseContext, MainActivity::class.java)
            startActivity(intent)
        }
    }

    fun cast() {
        email = findViewById(R.id.etEmail)
        password = findViewById(R.id.etPassword)
        btn1 = findViewById(R.id.btnLogin)
        btn2 = findViewById(R.id.btnSignup)
    }
}

