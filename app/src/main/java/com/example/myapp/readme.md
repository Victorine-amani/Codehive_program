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


Launch creates the coroutine and launches it to the dispatcher that interacts with the server to 
get your response which is taken by the coroutine back to the viewModel and then displayed in the UI