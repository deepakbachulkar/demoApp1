package com.demo.testapp.model

data class RequestVerifyOtp(
    val method: String,
    val mobile_no: String,
    val otp:String
)