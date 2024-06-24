package com.demo.testapp.networkcall

import com.demo.testapp.model.RequestLogin
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiCallServices {

        @POST("api")
        fun getOtp(
                @Header("key") header: String,
                @Body body: RequestLogin) : Call<Any>

//         @POST("/verifyOtp")
//        suspend fun verifyOtp(body: RequestBody) : RequestBodyesponse<Any>
}