package com.example.day8_1.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "colors")
data class Color(
    @PrimaryKey(autoGenerate = true)
    val _id : Int = 0,

    @ColumnInfo(name = "hex_color")
    val hex : String,

    val name : String,
) : Serializable
