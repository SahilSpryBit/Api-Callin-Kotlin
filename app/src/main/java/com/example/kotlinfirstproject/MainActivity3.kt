package com.example.kotlinfirstproject

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.lifecycleScope
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var clicklayout = findViewById(R.id.clicklayout) as ConstraintLayout

        clicklayout.setOnClickListener{

            var intent1 = Intent(this@MainActivity3, MainActivity4::class.java)
            startActivity(intent1)
        }

        ApiCall()
    }

    fun ApiCall(){

        var retrofit = RetrofitInstance.getInstance()
        var apiInterface = retrofit.create(QuotesApi::class.java)

        var list = apiInterface.getBaseURL("2", "1.1", "1")

            try {

                list!!.enqueue(object : Callback<GetBaseURLResponseModel?> {
                    override fun onResponse(
                        call: Call<GetBaseURLResponseModel?>,
                        response: Response<GetBaseURLResponseModel?>
                    ) {
                        if(response.isSuccessful){

                            if(response.body()!!.status == true){
                                var baseurlfromapi : String = response.body()!!.data?.base_url.toString()+"/"
                                var sessionManager = SessionManager(this@MainActivity3)

                                sessionManager.setBaseURL(baseurlfromapi+"/")
                            val str = Gson().toJson(response.body())

                            var message : String = response.body()!!.message.toString()

                                Toast.makeText(this@MainActivity3, message, Toast.LENGTH_SHORT).show()
                            Toast.makeText(this@MainActivity3, sessionManager.getBaseURL(this@MainActivity3), Toast.LENGTH_SHORT).show()

                            }

                        }else{
                            Toast.makeText(this@MainActivity3, "ELSEEE", Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<GetBaseURLResponseModel?>, t: Throwable) {
                        Toast.makeText(this@MainActivity3, t.localizedMessage+"\nfaill", Toast.LENGTH_LONG).show()
                    }

                })



//                if (response != null){
//
//                    response.enqueue(object : ServiceCallback<GetBaseURLResponseModel?>(),
//                        Callback<GetBaseURLResponseModel?> {
//                        override fun onFail(error: ServiceError?) {
//                            // Globle.setLog(tag, "user detail error");
//                            //callBack.invoke(false)
//                        }
//
//                        override fun onSuccess(response: GetBaseURLResponseModel?) {
//                            try {
//                                if (response != null && response.status != null && response.status && response.data != null && response.data
//                                        .base_url != null
//                                ) {
//                                    Toast.makeText(this@MainActivity3, "SUCCEESS RESPONSE", Toast.LENGTH_LONG).show()
//                                }
//                            } catch (e: java.lang.Exception) {
//                                e.printStackTrace()
//
//                            }
//                        }
//                    })
//
//                    Toast.makeText(this@MainActivity3, "Successs \n", Toast.LENGTH_LONG).show()
//
//                } else {
//                    Toast.makeText(
//                        this@MainActivity3,
//                        "Elseee",
//                        Toast.LENGTH_LONG
//                    ).show()
//                }
            }catch (Ex:Exception){
                Log.e("Error",Ex.localizedMessage)
            }
    }
}

