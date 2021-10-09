package com.example.day8_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import com.example.day8_1.Model.ColorDatabase
import com.example.day8_1.databinding.ActivityAddColorBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddColorActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    private lateinit var binding : ActivityAddColorBinding
    private val db : ColorDatabase by lazy {
        ColorDatabase.getInstance(applicationContext)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_color)

        with(binding) {
            redSeekBar.setOnSeekBarChangeListener(this@AddColorActivity)
            greenSeekBar.setOnSeekBarChangeListener(this@AddColorActivity)
            blueSeekBar.setOnSeekBarChangeListener(this@AddColorActivity)

            btnAddColor.setOnClickListener {
                CoroutineScope(Dispatchers.IO).launch {
                    db.colorDao().insert(
                        com.example.day8_1.Model.Color(
                            hex = txtColorHex.text.toString(),
                            name = editTextColorTitle.text.toString()
                        )
                    )
                    setResult(RESULT_OK)
                    finish()
                }
            }
        }
    }

    override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
        with(binding){
            if(p2){
                val newColor = Color.argb(255,
                    redSeekBar.progress,
                    greenSeekBar.progress,
                    blueSeekBar.progress,
                )

                colorView.setBackgroundColor(newColor)
                val hexColor = String.format("#%06X", (0xFFFFFF and newColor))
                txtColorHex.text = hexColor


                txtAddColorRedPersent.text = redSeekBar.progress.toString()
                txtAddColorGreenPersent.text = greenSeekBar.progress.toString()
                txtAddColorBluePersent.text = blueSeekBar.progress.toString()
            }
        }
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {}

    override fun onStopTrackingTouch(p0: SeekBar?) {}
}