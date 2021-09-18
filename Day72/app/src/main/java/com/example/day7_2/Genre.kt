package com.example.day7_2

data class Genre(
    val name : String,
    val movies : List<Movie>
)

data class Movie(
    val name : String,
    val poster : Int,
    val desc : String,
)
