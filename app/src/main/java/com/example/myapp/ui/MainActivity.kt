package com.example.myapp.ui

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.myapp.R
import com.example.myapp.databinding.ActivityMainBinding
import com.example.myapp.models.RegistrationRequests
import com.example.myapp.viewModel.UserViewModel




class MainActivity : AppCompatActivity() {
   private lateinit var binding:ActivityMainBinding
   private val userViewModel:UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
   binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
registerStudent()


    }

    override fun onResume() {
        super.onResume()
        binding.btnSign.setOnClickListener {
 if (binding.etName.text.toString().isEmpty()||
    binding.etDOB.text.toString().isEmpty()||
    binding.etPhone.text.toString().isEmpty()||
    binding.etPassword.text.toString().isEmpty()||
    binding.etEmail.text.toString().isEmpty()
        ){
    binding.etName.setError("fill in all fields")
    binding.etEmail.setError("fill in all fields")
    binding.etPhone.setError("fill in all fields")
    binding.etPassword.setError("fill in all fields")
    binding.etDOB.setError("fill in all fields")
        }
        }
    }
 fun registerStudent() {

     val name = binding.etName.text.toString()
     val email = binding.etEmail.text.toString()
     val dateOfBirth = binding.etDOB.text.toString()
     val phoneNumber = binding.etPhone.text.toString()
     val password = binding.etPassword.text.toString()
     var nation = arrayOf("KENYAN", "UGANDAN", "RWANDESE","SOUTH SUDANESE")
     val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_item, nation)
     adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
     binding.spNation.adapter=adapter
     val nationality = binding.spNation.selectedItem.toString().toUpperCase()


     var registrationRequest = RegistrationRequests(
         name = name,
         phoneNumber = phoneNumber,
         email = email,
         dateOfBirth = dateOfBirth,
         nationality = nationality,
         password = password
     )
     userViewModel.registerStudent(registrationRequest)
     userViewModel.registrationLiveData.observe(this,{registrationResponse->
         if (registrationResponse.studentId.isNullOrEmpty()){
             Toast.makeText(baseContext,"registration successful",Toast.LENGTH_LONG).show()
         }
     })
     userViewModel.regErrorLiveData.observe(this,{ error->
         Toast.makeText(baseContext,error,Toast.LENGTH_LONG).show()
     })

 }}