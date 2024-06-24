package com.demo.testapp.ui.verifyotp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.testapp.model.RequestLogin
import com.demo.testapp.networkcall.ApiCallServices
import com.demo.testapp.networkcall.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VerifyOtpViewModel : ViewModel() {

    val mutableLiveData = MutableLiveData<Any>()
    val otp by lazy { MutableLiveData("") }

    fun apiCall(){
        val api = RetrofitInstance.getInstance().create(ApiCallServices::class.java)
        val jsonBody = RequestLogin("verifyOtp", otp.value?:"", "10")

        val call = api.getOtp("98acf1f2384fbc080fad8bc30589fed1aa9ef448", jsonBody)
        call.enqueue(object : Callback<Any> {
            override fun onResponse(call: Call<Any>, response: Response<Any>) {
                if (response.isSuccessful && response.body()!=null){
                    if(response.body() == 200){
                        mutableLiveData.value = response.body()
                    }else {
                        mutableLiveData.value = "Error"

                    }
                }
            }

            override fun onFailure(call: Call<Any>, t: Throwable) {
                t.printStackTrace()
            }

        })

    }
}