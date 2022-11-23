package com.example.kotlinfirstproject

import com.hiyamate.model.login.response.AddressDetails
import com.hiyamate.model.login.response.CompanyDetails
import com.hiyamate.model.login.response.UserDetails


class LoginResponse {

    var key: String? = null
    var company : CompanyDetails? = null
    var user : UserDetails? = null
    var address : AddressDetails? = null

}