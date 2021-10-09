package com.example.day8_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.day8_1.Model.Color
import com.example.day8_1.Model.ColorDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ColorDetailActivity : AppCompatActivity() {
    private val db : ColorDatabase by lazy {
        ColorDatabase.getInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_color_detail)


        val color = intent.getSerializableExtra("color") as Color
        findViewById<View>(R.id.colorDetailView).setBackgroundColor(
            android.graphics.Color.parseColor(color.hex)
        )
        findViewById<TextView>(R.id.txtHex).text = color.hex
        findViewById<TextView>(R.id.txtColorName).text = color.name

        findViewById<Button>(R.id.btnRemove).setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                db.colorDao().delete(color)
                finish()
            }
        }
    }
}