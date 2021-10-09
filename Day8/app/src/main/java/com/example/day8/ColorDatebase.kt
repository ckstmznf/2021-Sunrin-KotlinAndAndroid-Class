package com.example.day8

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Color::class], version = 1)
abstract class ColorDatebase : RoomDatabase() {
    abstract fun colorDao() : colorDao
    companion object{
        @Volatile
        private var INSTANCE : ColorDatebase? = null
        fun getInstance(context : Context) : ColorDatebase{
            return INSTANCE ?: synchronized(this){
                INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    ColorDatebase::class.java, "color_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                    .also{ INSTANCE = it}
            }
        }
    }
}