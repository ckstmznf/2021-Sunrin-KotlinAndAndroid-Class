package com.example.day5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {

    val activityResultCallback = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        if(it.resultCode == RESULT_OK){
            Toast.makeText(applicationContext, "${it.data!!.getStringExtra("name")}", Toast.LENGTH_LONG)
                .show()
        }
    }

//    val contactResultCallback = registerForActivityResult(
//        ActivityResultContracts.PickContact(){
//
//        }
//    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn1).setOnClickListener {
            activityResultCallback.launch(
                Intent(this, SubActivity::class.java)
            )
        }
    }
}