package com.example.kotlinfirstproject

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class GetBaseURLResponseModel {

    @SerializedName("status")
    @Expose
    val status: Boolean? = null

    @SerializedName("status_code")
    @Expose
    val status_code: Int? = null

    @SerializedName("message")
    @Expose
     val message: String? = null

    @SerializedName("error")
    @Expose
     val error: String? = null

    @SerializedName("data")
    @Expose
     val data: GetBaseURLModel? = null


}