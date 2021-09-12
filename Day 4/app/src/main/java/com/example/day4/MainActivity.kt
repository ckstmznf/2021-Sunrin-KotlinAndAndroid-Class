package com.example.day4

import android.app.DatePickerDialog
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputId = findViewById<EditText>(R.id.edt_main_studentId)
        val idWR = findViewById<TextView>(R.id.txt_main_studentIdWR)
        val inputName = findViewById<EditText>(R.id.edt_main_name)
        val nameWR = findViewById<TextView>(R.id.txt_main_studentNameWR)
        val unitGroup = findViewById<RadioGroup>(R.id.radioGroup_main_unit)
        val radioAt = findViewById<RadioButton>(R.id.radio_main_at)
        val radioPx = findViewById<RadioButton>(R.id.radio_main_px)
        val unitEx = findViewById<TextView>(R.id.txt_main_unitEx)
        val inputMotive = findViewById<EditText>(R.id.edt_main_motive)
        val motiveWR = findViewById<TextView>(R.id.txt_main_motiveWR)
        val applyBtn = findViewById<Button>(R.id.btn_main_apply)


        var studentId : String
        var studentName : String
        var unit = radioAt.text.toString()


        inputId.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(p3 != 5){
                    idWR.visibility = View.VISIBLE
                }   else{
                    idWR.visibility = View.INVISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        inputName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Log.d("textChange", "${p1}, ${p2}, $p3, ${p0?.length!!}")
                if(p3 < 2){
                    nameWR.visibility = View.VISIBLE
                }   else{
                    nameWR.visibility = View.INVISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })


        unitGroup.setOnCheckedChangeListener{group, checkId ->
            when(checkId){
                R.id.radio_main_at -> {
                    unit = radioAt.text.toString()
                    unitEx.text = "Atelier는 소프트웨어과가 지원할 수 있는 개발 유닛이며, 뛰어난 문제 해결력과 창의력을 지닌 개발자를 양성합니다."
                }
                R.id.radio_main_px -> {
                    unit = radioPx.text.toString()
                    unitEx.text = "Pixel은 콘텐츠디자인과가 지원할 수 있는 디자인 유닛이며, 뛰어난 분석력과 창의력을 지닌 디자이너를 양성합니다."
                }
            }
        }


        inputMotive.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val length = p0?.length
                motiveWR.text = "150자 제한 ($length / 150)"
                Log.d("txt", "150자 제한 ($length / 150)")

                if(length!! <= 150){
                    motiveWR.setTextColor(Color.parseColor("#0000FF"))
                }   else{
                    motiveWR.setTextColor(Color.parseColor("#FF0000"))
                }
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })

        applyBtn.setOnClickListener {
            Toast.makeText(this, "EDCAN에 지원해주셔서 감사합니다.\n이제 지원자님께 잠이란 없습니다.\nEvery Day Create All Night", Toast.LENGTH_LONG).show()
        }




    }
}