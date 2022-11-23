package com.example.kotlinfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

    class MainActivity2 : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_main2)

            var recyclerview = findViewById(R.id.recyclerview) as RecyclerView

            recyclerview.layoutManager = LinearLayoutManager(this)

            var intent : Intent = getIntent()
            var value: Int = intent.getIntExtra("Value", 0)

            val data = ArrayList<ItemsViewModel>()

            for (i in 1..value) {
                data.add(ItemsViewModel(R.drawable.ic_launcher_background, "Item " + i))
            }

            val adapter = Adapter(data)

            recyclerview.adapter = adapter
        }
}