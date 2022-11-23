package com.example.kotlinfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import com.hiyamate.model.login.request.LoginRequest
import com.hiyamate.model.login.response.LoginResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        var email = findViewById(R.id.email) as EditText
        var pass = findViewById(R.id.pass) as EditText
        var btnn= findViewById(R.id.btnn) as Button

        btnn.setOnClickListener{

            var emailstr: String = email.text.toString()
            var passstr: String = pass.text.toString()
            ApiCall(email.text.toString(), pass.text.toString())
        }
    }

    fun ApiCall(email1:String, pass1:String){

        var retrofit = RetrofitInstance2.getInstance()
        var apiInterface = retrofit.create(QuotesApi::class.java)

        val login =
            LoginRequest(email1, pass1)

        var data = apiInterface.login("1", "12346578901234657890123465789022221234657890123465789012346578902222", login)

        try {

            data!!.enqueue(object : Callback<LoginResponseModel?> {
                override fun onResponse(
                    call: Call<LoginResponseModel?>,
                    response: Response<LoginResponseModel?>
                ) {
                    if(response.isSuccessful){

                        if(response.body()!!.status == true){

                            val str = Gson().toJson(response.body())

                            var message : String = response.body()!!.message.toString()

                            var baseurlfromapi : String = response.body()!!.data?.key.toString()

                            Toast.makeText(this@MainActivity5, baseurlfromapi, Toast.LENGTH_LONG).show()
                            Toast.makeText(this@MainActivity5, message, Toast.LENGTH_LONG).show()

//                            var intent1 = Intent(this@MainActivity5, MainActivity4::class.java)
//                            intent1.putExtra("BASE_URL_LOGINAPI", baseurlfromapi)
//                            startActivity(intent1)

                            Toast.makeText(this@MainActivity5, str, Toast.LENGTH_LONG).show()
                        }

                    }else{
                        Toast.makeText(this@MainActivity5, "ELSEEE "+response.errorBody(), Toast.LENGTH_LONG).show()
                        Log.d("Error", response.errorBody().toString())
                    }
                }

                override fun onFailure(call: Call<LoginResponseModel?>, t: Throwable) {
                    Log.d("Error", t.localizedMessage)
                    Toast.makeText(this@MainActivity5, t.localizedMessage+"\nfaill", Toast.LENGTH_LONG).show()
                }

            })

        }catch (Ex:Exception){
            Log.e("Error",Ex.localizedMessage)
        }
    }
}