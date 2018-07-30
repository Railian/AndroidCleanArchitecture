package ua.raylyan.cleanarch.platform.network.entity

import com.google.gson.annotations.SerializedName

internal data class RetrofitComment(
        @SerializedName("postId") val postId: Long,
        @SerializedName("id") val id: Long,
        @SerializedName("email") val email: String,
        @SerializedName("body") val body: String
)