package com.example.day9

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Post(
    val title : String,
    val description : String,
    val url : String,
    val updated : String,
    val thumbnail : String,
    val closedCaption : String?
)
