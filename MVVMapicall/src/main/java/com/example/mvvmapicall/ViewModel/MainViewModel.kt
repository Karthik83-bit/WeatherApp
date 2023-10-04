package com.example.mvvmapicall.ViewModel

import androidx.lifecycle.*
import com.example.mvvmapicall.Models.Data.APIdata
import com.example.mvvmapicall.Repository.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(private val repo:WeatherRepository,val Query:String):ViewModel(),LifecycleObserver{


    val data: LiveData<APIdata>
        get() {
            return repo.weatherdata
        }

    init {
        viewModelScope.launch(Dispatchers.IO){
            repo.getRes(Query)

        }
    }
    fun getWeather(userinp:String){
        viewModelScope.launch(Dispatchers.IO){
            repo.getRes(userinp)

        }
    }
}