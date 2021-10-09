package com.example.day8

import androidx.room.Entity

@Entity(tableName = "Colors")
data class Color(
    val _id : Int = 0,
    val hex : String,
    val name : String
)
