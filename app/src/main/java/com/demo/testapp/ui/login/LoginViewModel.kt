package com.demo.testapp.ui.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.testapp.model.RequestLogin
import com.demo.testapp.networkcall.ApiCallServices
import com.demo.testapp.networkcall.RetrofitInstance
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {
    val mutableLiveData = MutableLiveData<Any>()
    val phoneNumber by lazy { MutableLiveData("") }


    fun apiCall(){
        val api = RetrofitInstance.getInstance().create(ApiCallServices::class.java)
        val jsonBody = RequestLogin("getOtp", phoneNumber.value?:"", "10")

        val call = api.getOtp("6997c339387ac79b5fec7676cd6170b0d8b1e79c", jsonBody)
        call.enqueue(object : Callback<Any>{
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


