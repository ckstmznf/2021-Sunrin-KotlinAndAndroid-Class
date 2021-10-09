package com.example.day5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.navigation.findNavController

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        findViewById<Button>(R.id.btnB).setOnClickListener {
            findNavController(R.id.fragmentContainerView).navigate(R.id.)
        }
    }
}
