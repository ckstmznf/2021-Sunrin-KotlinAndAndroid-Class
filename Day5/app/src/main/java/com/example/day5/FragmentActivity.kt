package com.example.day5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentActivity : AppCompatActivity() {
    lateinit var navController : androidx.fragment.app.FragmentContainerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        navController = findViewById(R.id.nav)
    }

    fun navigateToDetail(){
        navController.n
    }
}