package com.example.day8

import androidx.room.*

@Dao
interface colorDao {
    @Query("SELECT * FROM colors")
    fun getAll() : Array<Color>

    @Insert
    fun insert(vararg color : Color)
    @Update
    fun update(color : Color)
    @Delete
    fun delete(color : Color)
}