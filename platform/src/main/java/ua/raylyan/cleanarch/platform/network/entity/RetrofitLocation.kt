package ua.raylyan.cleanarch.platform.network.entity

import com.google.gson.annotations.SerializedName

internal data class RetrofitLocation(
        @SerializedName("lat") val latitude: Double,
        @SerializedName("lng") val longitude: Double
)