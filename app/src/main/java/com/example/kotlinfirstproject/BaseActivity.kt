package com.example.kotlinfirstproject

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson

open class BaseActivity : AppCompatActivity() {


    lateinit var gson: Gson

//    lateinit var screenManager: ScreenManager
    lateinit var sessionManager: SessionManager
//    lateinit var dialogUtil: DialogUtil
//    lateinit var progressDialogUtil: ProgressDialogUtil

    var deviceType = "2"; //device type: 1=IOS, 2=Android
    var versionCode = ""
    var deviceId = ""
    var gstPercent = ""
    var ID_Status = ""
    var ID_Color = ""
    var notification_unread_count = ""

    var sort_option = "1"
    //    var distance_km = "25"
    var distance_km = "50"
    var available_task = "2"

    var length = "1000"
    var start = "0"
    var country = "AU"
    val MAX_NUMBER = "MaxNumber"
    val REQUEST_CODE_PICK_FILE = 0x400
    val RESULT_PICK_FILE = "ResultPickFILE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        screenManager = ScreenManager(this)
        sessionManager = SessionManager(this)

//        progressDialogUtil = ProgressDialogUtil(this)
//        dialogUtil = DialogUtil(this)

        versionCode = BuildConfig.VERSION_NAME

//        deviceId = Globle.getDeviceId(this)
//        gson = Gson()
//
//        if (sessionManager.getFilterData() != null){
//            if (!sessionManager.getFilterData()!!.job_distance_in_km.isNullOrEmpty()){
//                distance_km = sessionManager.getFilterData()!!.job_distance_in_km.toString()
//            }
//            if (!sessionManager.getFilterData()!!.sort_option.isNullOrEmpty()){
//                sort_option = sessionManager.getFilterData()!!.sort_option.toString()
//            }
//            if (!sessionManager.getFilterData()!!.available_task_only.isNullOrEmpty()){
//                available_task = sessionManager.getFilterData()!!.available_task_only.toString()
//            }
//        }


    }

    fun hideStatusbar() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                // window.insetsController?.hide(WindowInsets.Type.statusBars())
                /*val controller = window.insetsController
            controller?.systemBarsBehavior = BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            controller?.hide(WindowInsets.Type.statusBars())*/
                window.setDecorFitsSystemWindows(false)
                val controller = window.insetsController
                if (controller != null) {
                    controller.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                    controller.systemBarsBehavior =
                        WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }

            } else {
                window.setFlags(
                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN
                )
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }

}