package com.example.kotlinfirstproject

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetBaseURLModel {
    @SerializedName("application_version")
    @Expose
    val application_version: String? = null

    @SerializedName("application_type")
    @Expose
    val application_type: String? = null

    @SerializedName("base_url")
    @Expose
    val base_url: String? = null
}