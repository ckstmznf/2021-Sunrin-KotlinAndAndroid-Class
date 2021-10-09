package com.example.day8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.coroutines.CoroutineContext

class MainActivity : AppCompatActivity() {
    private val bd : ColorDatebase by lazy { ColorDatebase.getInstance(applicationContext)}
    private val recyclerView : RecyclerView by Lazy {findViewById<RecyclerView>(R.id.recycler_main_colorList)}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<FloatingActionButton>(R.id.floatingActionButton).setOnClickListener{
            startActivity(
                Intent(this, AddColorActivity::class.java)
            )
        }

    }

    override fun onResume() {
        super.onResume()
        refreshUI()
    }

    private fun refreshUI(){
//        CoroutineScope()
    }
}