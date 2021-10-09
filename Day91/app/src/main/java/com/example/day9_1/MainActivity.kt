package com.example.day9_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telecom.Call
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://www.googleapis.com/youtube/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(YoutubeInfoAPI::class.java)

    private lateinit var txtTitle : TextView
    private lateinit var txtDescription : TextView
    private lateinit var txtChannel : TextView
    private lateinit var img : ImageView
    private lateinit var inputURL : EditText

    private val youtubeUrlWatcher = object : TextWatcher{
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

        }

        override fun afterTextChanged(p0: Editable?) {
            val matchResult = Regex("^((?:https?:)?//)?((?:www|m)\\.)?((?:youtube\\.com|youtu.be))(\\/(?:[\\w\\-]+\\?v=|embed/|v/)?)([\\w\\-]+)(\\S+)?\$")
                .find(p0.toString())

            if(matchResult != null){
                if(matchResult.groupValues.size > 5){
                    if(matchResult.groupValues[5].length > 10){
                        CoroutineScope(Dispatchers.Main).launch {
                            val data = getVideoInfo(matchResult.groupValues[5]).itemEntity[0]
                            txtTitle.text = data.snippet.title
                            Log.d("youtube title", data.snippet.title)
                            txtDescription.text = data.snippet.description
                            Log.d("youtube description", data.snippet.description)
                            txtChannel.text = data.snippet.channelTitle
                            Log.d("youtube channelTitle", data.snippet.channelTitle)
                            Glide.with(this@MainActivity).load(data.snippet.thumbnails.high.url).into(img)
                        }
                    }
                }
            }
        }

    }
//https://www.youtube.com/watch?v=q3_WXP9pPUQ
    suspend fun getVideoInfo(id : String) : YoutubeRetrofitEntity {
        return CoroutineScope(Dispatchers.IO).async {
            retrofit.getVideoInfo(id, "AIzaSyBJbSFva5WSUJJWQemy8jtxmDpjlAsE5bE")
        }.await()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTitle = findViewById(R.id.txt_main_title)
        txtDescription = findViewById(R.id.txt_main_description)
        txtChannel = findViewById(R.id.txt_main_channel)
        img = findViewById(R.id.img_main_img)
        inputURL = findViewById(R.id.edt_main_inputUrl)


        inputURL.addTextChangedListener(youtubeUrlWatcher)
    }
}