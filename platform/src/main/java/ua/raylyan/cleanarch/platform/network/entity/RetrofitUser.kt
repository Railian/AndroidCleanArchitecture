package ua.raylyan.cleanarch.platform.network.entity

import com.google.gson.annotations.SerializedName

internal data class RetrofitUser(
        @SerializedName("id") val id: Long,
        @SerializedName("name") val name: String,
        @SerializedName("username") val username: String,
        @SerializedName("email") val email: String,
        @SerializedName("address") val address: RetrofitAddress,
        @SerializedName("phone") val phone: String,
        @SerializedName("website") val website: String,
        @SerializedName("company") val company: RetrofitCompany
)