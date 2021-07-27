package com.example.myapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.Api.ApiClient
import com.example.myapp.Api.ApiInterface
import com.example.myapp.models.RegistrationRequests
import com.example.myapp.models.RegistrationResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var spNation: Spinner
    private lateinit var etEmail: EditText
    private lateinit var etPhone: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnSign: Button
    private lateinit var dateOfBirth:EditText
    override fun onCreate(savedInstanceState: Bundle?) {super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        register()
castViews()



    }
    fun register(){
castViews()
        val name=etName.text.toString()
        val email=etEmail.text.toString()
        val phone_number=etPhone.text.toString()
        val password=etPassword.text.toString()

        val date_of_birth=dateOfBirth.text.toString()

        val nationality = arrayOf("KENYAN", "UGANDAN", "RWANDESE","SOUTH SUDANESE")
        val adapter = ArrayAdapter(baseContext, android.R.layout.simple_spinner_item, nationality)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spNation.adapter = adapter
        val nation=spNation.selectedItem.toString()
        btnSign.setOnClickListener {

                var registrationRequest= RegistrationRequests(
                    name=name,
                    phoneNumber= phone_number,
                    email=email,
                    nationality=nation,
                    password=password,
                    dateOfBirth = date_of_birth)
                val retrofit=ApiClient.buildApiClient(ApiInterface::class.java)
                var request=retrofit.register(registrationRequest)
                request.enqueue(object : Callback<RegistrationResponse?> {
                    override fun onResponse(
                        call: Call<RegistrationResponse?>,
                        response: Response<RegistrationResponse?>
                    ) {
                        if (response.isSuccessful){
                            Toast.makeText(baseContext,"Registration Successful",Toast.LENGTH_LONG).show()
                            var intent = Intent(baseContext, Login::class.java)
                            startActivity(intent)

                        }
                        else{
                            try {
                                val error = JSONObject(response.errorBody()!!.string())
                                Toast.makeText(baseContext,error.toString(), Toast.LENGTH_LONG).show()
                            }
                            catch (e:Exception){
                                Toast.makeText(baseContext,e.message, Toast.LENGTH_LONG).show()
                            }
                        }
                    }

                    override fun onFailure(call: Call<RegistrationResponse?>, t: Throwable) {
                        Toast.makeText(baseContext,t.message,Toast.LENGTH_SHORT).show()
                    }
                })


        }

    }
    data class ApiError(var errors:List<String>)


        

    fun castViews(){
        etName = findViewById(R.id.etName)
        spNation = findViewById(R.id.spNation)
        etEmail = findViewById(R.id.etEmail)
        etPhone = findViewById(R.id.etPhone)
        etPassword = findViewById(R.id.etPassword)
        btnSign = findViewById(R.id.btnSign)
        dateOfBirth=findViewById(R.id.etDOB)
    }

}

