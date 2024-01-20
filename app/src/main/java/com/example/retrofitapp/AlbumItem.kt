package com.example.retrofitapp

import com.google.gson.annotations.SerializedName

// 1 - Data Classes (POJO)
data class AlbumItem(

    /**
     * SerializedName: An annotation that indicates this member should be serialized to JSON with the provided name value as its field name.
     */

    @SerializedName("id")
    val id: Int,

    @SerializedName("userId")
    val userId: Int,

    @SerializedName("title")
    val title: String,
)