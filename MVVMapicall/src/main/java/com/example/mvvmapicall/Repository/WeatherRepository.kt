package com.example.mvvmapicall.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmapicall.Models.Data.APIdata
import com.example.mvvmapicall.Models.api.WeatherService

class WeatherRepository(val service: WeatherService) {
    private val mutableliveData= MutableLiveData<APIdata>()
    private lateinit var acessKey:String
    val weatherdata:LiveData<APIdata>
        get() {
            return mutableliveData
        }


    suspend fun getRes(query:String){
        acessKey="58d5a544b53c055f8ef92f15f0a16413"
        val resp=service.getData(acessKey, query)
        if(resp.body()!=null){
            mutableliveData.postValue(resp.body())
        }



    }
}