package com.example.kotlinfirstproject

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson

class SessionManager(private var context: Context) {

    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences("SharedPref", Context.MODE_PRIVATE)

    fun setBaseURL(strBaseURL: String?) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("BASE_URL_KEY", strBaseURL)
        editor.apply()
        editor.commit()
    }

    fun getBaseURL(context: Context): String {
        return sharedPreferences.getString("BASE_URL_KEY", "")!!
    }

    fun clearAllData() {

        val editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()

    }

    fun getFirstDataUpload(): Boolean {
        return sharedPreferences.getBoolean("PREF_IS_FIRST_DATA_UPLOAD", false)
    }

    fun setFirstDataUpload(isUpload: Boolean) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putBoolean("PREF_IS_FIRST_DATA_UPLOAD", isUpload)
        editor.apply()
        editor.commit()
    }

    //

    fun setUserData(loginResponse: LoginResponse) {
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("loginData", Gson().toJson(loginResponse))
        editor.apply()
        editor.commit()
    }

    fun getUserData(): LoginResponse? {
        var loginResponseModel: LoginResponse? = null
        try {
            val strLoginData: String? = sharedPreferences.getString("loginData", null)
            if (!strLoginData.isNullOrEmpty()) {
                loginResponseModel = Gson().fromJson(strLoginData, LoginResponse::class.java)
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        return loginResponseModel
    }

}