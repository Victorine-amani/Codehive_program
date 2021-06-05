package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var spGender: Spinner
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSign: Button
    override fun onCreate(savedInstanceState: Bundle?) {super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        views()
        spin()


        btnSign.setOnClickListener {
            if (etName.text.toString() == "") {
                etName.setError("Fill in all fields")
            }
            else if (etEmail.text.toString() == "") {
                etEmail.setError("Fill in all fields")
            }
            else if (etPhone.text.toString() == "") {
                etPhone.setError("Fill in all fields")
            }
            else if (etPassword.text.toString() == "") {
                etPassword.setError("Fill in all fields")
            }else {
               val intent = Intent(baseContext, Login::class.java)
               startActivity(intent)
            }
        }


    }


    private fun views() {
        etName = findViewById(R.id.etName)
        spGender = findViewById(R.id.spGender)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        btnSign = findViewById(R.id.btnSign)
    }

    private fun spin() {
        val gender = arrayOf("Female", "Male", "Other")
        val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_item, gender)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spGender.adapter = adapter
    }




}