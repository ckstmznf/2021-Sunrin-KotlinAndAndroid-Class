package com.example.day7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = arrayOf("#0000FF", 24, 36, "#FF0000", 7, "#00FF00", 121)

        val recycle = findViewById<androidx.recyclerview.widget.RecyclerView>(R.id.recycle_main_list)
        recycle.adapter = MyAdapter(arrayOf("#0000FF", 24, 36, "#FF0000", 7, "#00FF00", 121))
//        recycle.layoutManager
    }
}