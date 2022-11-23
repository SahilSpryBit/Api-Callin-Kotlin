package com.example.kotlinfirstproject


data class FirstTimeCompanyInstallRequest (

    var device_type: String? = null,
    var device_token : String? = null,
    var device_uuid : String? = null,
    var application_version : String? = null,
    var company_user_id : String? = null

)