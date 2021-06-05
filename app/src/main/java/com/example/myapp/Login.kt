package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class Login : AppCompatActivity() {
    lateinit var email:EditText
    lateinit var password:EditText
    lateinit var btn1:Button
    lateinit var btn2:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

cast()
        btn1.setOnClickListener {
            if (email.text.toString().isEmpty()) {
                email.setError("fill in all fields")
            } else if (password.text.toString().isEmpty()) {
                password.setError("Fill in all fields")
            } else {
                var intent2 = Intent(baseContext, welcome::class.java)
                startActivity(intent2)
            }
        }
        btn2.setOnClickListener {
            var intent3=Intent(baseContext,MainActivity::class.java)
            startActivity(intent3)
        }
    }
    fun cast(){
        email=findViewById(R.id.etEmail)
        password=findViewById(R.id.etPassword)
        btn1=findViewById(R.id.btnLogin)
        btn2=findViewById(R.id.btnSignup)
    }
}