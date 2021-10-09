package com.example.day8_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.day8_1.Model.ColorDatabase
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val db : ColorDatabase by lazy {
        ColorDatabase.getInstance(applicationContext)
    }

    private lateinit var recycler : RecyclerView
    private lateinit var addBtn : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        recycler = findViewById(R.id.recycler_main_colorList)
        addBtn = findViewById(R.id.floatBtn_main_addColor)

        addBtn.setOnClickListener{
            val intent = Intent(this, AddColorActivity::class.java)
            startActivity(intent)
        }
    }


    private fun refreshUI(){
        CoroutineScope(Dispatchers.IO).launch {
            val data = db.colorDao().getAll().toMutableList()

            withContext(Dispatchers.Main){
                if(recycler.adapter == null)
                    recycler.adapter = ColorAdapter(data)
                else
                    (recycler.adapter as ColorAdapter).changeData(data)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        refreshUI()
    }
}