package com.example.day5_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        val parent = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.par)
        when(item.itemId){
            R.id.menu1 -> Toast.makeText(this, "역시 에드캔", Toast.LENGTH_LONG).show()
            R.id.menu2 -> Toast.makeText(this, "애플파이", Toast.LENGTH_LONG).show()
            R.id.menu3 -> Toast.makeText(this, "아이왑", Toast.LENGTH_LONG).show()
            R.id.menu4 -> Toast.makeText(this, "게임공화국", Toast.LENGTH_LONG).show()
            R.id.menu5 -> Toast.makeText(this, "오픈소스", Toast.LENGTH_LONG).show()
            R.id.menu6 -> Toast.makeText(this, "아나", Toast.LENGTH_LONG).show()
        }
        
        return true
    }

}