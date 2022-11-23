package com.example.kotlinfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        
//        val intent = getIntent();
//        val myValue = intent.getStringExtra("BASE_URL_LOGINAPI")

        var textView2 = findViewById(R.id.textView2) as TextView
        var gotologinpage = findViewById(R.id.gotologinpage) as TextView

        var sessionmanager = SessionManager(this@MainActivity4)

        val myValue = sessionmanager.getBaseURL(this)

        textView2.setText(myValue)

        textView2.setOnClickListener{

            sessionmanager.clearAllData()
            var newvalue = sessionmanager.getBaseURL(this)
            textView2.setText(newvalue+ "EMPTY")

            Toast.makeText(this@MainActivity4, ""+sessionmanager.getBaseURL(this), Toast.LENGTH_SHORT).show()
        }

        gotologinpage.setOnClickListener{

            var intent = Intent(this@MainActivity4, MainActivity5::class.java)
            startActivity(intent)
        }

    }
}