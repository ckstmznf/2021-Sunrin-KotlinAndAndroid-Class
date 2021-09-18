package com.example.day5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SubActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub)

        findViewById<Button>(R.id.btn1).setOnClickListener {
            setResult(
                RESULT_OK,
                Intent().putExtra("name", findViewById<EditText>(R.id.edt1).text.toString())
            )
            finish()
        }
    }
}