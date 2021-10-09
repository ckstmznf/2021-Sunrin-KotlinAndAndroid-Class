package com.example.day9_1

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class YoutubeRetrofitEntity(
    @Expose
    @SerializedName("items")
    val itemEntity: List<ItemsEntity>
)

data class ItemsEntity (
    @Expose
    @SerializedName("id")
    val id : String,

    @Expose
    @SerializedName("snippet")
    val snippet : SnippetEntity,

    @Expose
    @SerializedName("contentDetails")
    val contentDetails : ContentDetailsEntity
)


data class ContentDetailsEntity(
    @Expose
    @SerializedName("duration")
    val duration: String
)

data class SnippetEntity(
    @Expose
    @SerializedName("title")
    val title : String,

    @Expose
    @SerializedName("thumbnails")
    val thumbnails: ThumbnailsEntity,

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
