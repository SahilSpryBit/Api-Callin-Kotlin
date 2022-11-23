package com.example.kotlinfirstproject

import com.hiyamate.model.login.request.LoginRequest
import com.hiyamate.model.login.response.LoginResponseModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.*

interface QuotesApi {

    @GET("/quotes")
    suspend fun getQuotes() : Response<QuoteList>

    @FormUrlEncoded
    @POST("base_url.php")
    open fun getBaseURL(
        @Field("application_platform") application_platform: String?,
        @Field("application_version") application_version: String?,
        @Field("application_type") application_type: String?
    ): Call<GetBaseURLResponseModel?>?

    @POST("api/application/v1/company/login")
    fun login(
        @Header("Device-Type") device_type: String?,
        @Header("Device-Uuid") device_uuid: String?,
        @Body login: LoginRequest?
    ): Call<LoginResponseModel?>?


    @POST("api/application/v1/company/user/installation")
    fun companyIntallationFirstTimeCall(
        @Header("Device-Type") device_type: String?,
        @Header("Device-Uuid") device_uuid: String?,
        @Body firstTimeCompanyInstallRequest: FirstTimeCompanyInstallRequest?
    ): Call<CommonResponseModel?>?
}