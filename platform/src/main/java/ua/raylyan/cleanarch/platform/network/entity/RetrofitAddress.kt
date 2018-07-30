package ua.raylyan.cleanarch.platform.network.entity

import com.google.gson.annotations.SerializedName

internal data class RetrofitAddress(
        @SerializedName("street") val street: String,
        @SerializedName("suite") val suite: String,
        @SerializedName("city") val city: String,
        @SerializedName("zipcode") val zipCode: String,
        @SerializedName("geo") val location: RetrofitLocation
)