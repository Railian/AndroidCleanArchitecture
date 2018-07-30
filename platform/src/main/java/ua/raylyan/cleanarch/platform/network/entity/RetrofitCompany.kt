package ua.raylyan.cleanarch.platform.network.entity

import com.google.gson.annotations.SerializedName

internal data class RetrofitCompany(
        @SerializedName("name") val name: String,
        @SerializedName("catchPhrase") val catchPhrase: String,
        @SerializedName("bs") val bs: String
)