package com.example.day9

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.time.Duration

//import com.google.gson.annotations.Expose

data class YoutubeRetrofitEntity(
    @Expose
    @SerializedName("items")
    val itemsEntity : List<ItemsEntity>
)

data class ItemsEntity(
    @Expose
    @SerializedName("id")
    val id : String,

    @Expose
    @SerializedName("snippet")
    val snippet : SinppetEntity,

    @Expose
    @SerializedName("contentDetails")
    val duration: ContentDetailsEtity
)

data class ContentDetailsEtity(
    @Expose
    @SerializedName("duration")
    val duration : String
)

data class SinppetEntity(
    @Expose
    @SerializedName("title")
    val title : String,

    @Expose
    @SerializedName("thumbnails")
    val thumbnails : ThumbnailsEntity,

    @Expose
    @SerializedName("channelTitle")
    val channelTitle : String,

    @Expose
    @SerializedName("description")
    val description : String
)

data class ThumbnailsEntity(
    @Expose
    @SerializedName("high")
    val high : ThumbnailEntity
)

data class ThumbnailEntity(
    @Expose
    @SerializedName("url")
    val url : String
)