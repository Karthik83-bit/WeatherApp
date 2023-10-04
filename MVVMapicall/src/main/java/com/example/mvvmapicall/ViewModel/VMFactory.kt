package com.example.mvvmapicall.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmapicall.Repository.WeatherRepository


class VMFactory(val repository: WeatherRepository,val query:String): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository,query)as T
    }

}