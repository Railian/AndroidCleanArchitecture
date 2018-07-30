package ua.raylyan.cleanarch.platform.network.entity

import com.google.gson.annotations.SerializedName

internal data class RetrofitPost(
        @SerializedName("userId") val userId: Long,
        @SerializedName("id") val id: Long,
        @SerializedName("title") val title: String,
        @SerializedName("body") val body: String
)