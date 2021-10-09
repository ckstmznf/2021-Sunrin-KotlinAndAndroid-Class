package com.example.day9

import retrofit2.http.*
import java.nio.file.attribute.PosixFileAttributeView

interface SimpleService {
    @GET("posts")
    suspend fun listAll() : List<Post>

    @GET("posts/{userId}")
    suspend fun listByUser(@Path("userId") userId : String) : List<Post>

    @GET("posts/search")
    suspend fun search(@Query("filter") search : String) : List<Post>

    @POST("posts/new")
    suspend fun create(@Body post : Post) : Post
}