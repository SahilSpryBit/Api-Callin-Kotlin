package com.example.kotlinfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.kotlinfirstproject.RetrofitInstance2.sessionManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            var btn = findViewById(R.id.btn) as Button
        var txt = findViewById(R.id.txt) as TextView

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)
        // launching a new coroutine
        GlobalScope.launch {
            val result = quotesApi.getQuotes()
            if (result != null){
            // Checking the results
                Log.d("sahil: ", result.body().toString())

        }}

        btn.setOnClickListener{

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("Value", 10)
            startActivity(intent)

            var sessionManager = SessionManager(this)

            sessionManager.clearAllData()
        }


    }
}