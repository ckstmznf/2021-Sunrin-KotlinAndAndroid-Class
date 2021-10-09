package com.example.day8

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.SeekBar

class AddColorActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {

    private val redSeek : SeekBar by lazy { findViewById(R.id.redSeekBar) }
    private val greenSeek : SeekBar by lazy { findViewById(R.id.greenSeekBar) }
    private val blueSeek : SeekBar by lazy { findViewById(R.id.blueSeekBar) }

    private val colorView : View by lazy { findViewById(R.id.colorView) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_color)

        redSeek.setOnSeekBarChangeListener(this)
        greenSeek.setOnSeekBarChangeListener(this)
        blueSeek.setOnSeekBarChangeListener(this)


        findViewById<Button>(R.id.btnAddColor).setOnClickListener {
            Co
        }
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        val newColor = android.graphics.Color.argb(
            255, redSeek.progress, greenSeek.progress, blueSeek.progress
        ) //시크바에서 새색상을 가져와서 새 색을 만든다.

        colorView.setBackgroundColor(newColor)
        val hexColor = String.format("#%06X", (0xFFFFFF and newColor))


    }

    override fun onStartTrackingTouch(p0: SeekBar?) {

    }

    override fun onStopTrackingTouch(p0: SeekBar?) {

    }
}