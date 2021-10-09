package com.example.day9_1

import retrofit2.Retrofit
import retrofit2.http.*

interface YoutubeInfoAPI {
    @GET("videos")
    suspend fun getVideoInfo(
        @Query("id") id : String,
        @Query("key") key : String,
        @Query("part") park : String = "snippet,contentDetails",
        @Query("fields") fields : String = "items(id,snippet(title,channelTitle,description,thumbnails(high(url))),contentDetails(duration))",
    ) : YoutubeRetrofitEntity
}