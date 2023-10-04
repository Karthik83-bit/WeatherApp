package com.example.mvvmapicall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.mvvmapicall.Models.api.RetrofitInst
import com.example.mvvmapicall.Models.api.WeatherService
import com.example.mvvmapicall.Repository.WeatherRepository
import com.example.mvvmapicall.ViewModel.MainViewModel
import com.example.mvvmapicall.ViewModel.VMFactory
import com.example.mvvmapicall.databinding.ActivityMvvmactivityBinding

class MVVMActivity : AppCompatActivity() {
    private lateinit var MVVMbinding:ActivityMvvmactivityBinding
    private lateinit var  viewModel: MainViewModel
    private lateinit var  vmFactory: VMFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MVVMbinding= ActivityMvvmactivityBinding.inflate(layoutInflater)

        setContentView(MVVMbinding.root)
        val repoService=RetrofitInst().getInst().create(WeatherService::class.java)
        val repo=WeatherRepository(repoService)
        vmFactory=VMFactory(repo,"New York")
        //        viewModel= ViewModelProviders.of(this as FragmentActivity,vmFactory).get(MainViewModel::class.java)
//        viewModel=ViewModelProvider(this,VMFactory("",""))
        val viewModel= ViewModelProvider(this,vmFactory)[MainViewModel::class.java]
        MVVMbinding.button.setOnClickListener {
            viewModel.getWeather(MVVMbinding.editTextTextPersonName.text.toString())
        }
        viewModel.data.observe(this, Observer{
            Log.d("msg",it.toString())
            if(it!=null) {
                MVVMbinding.cityname.text = it.location?.name
                MVVMbinding.tempText.text = it.current?.temperature.toString() + "C"
                MVVMbinding.timeText.text = it.location?.localtime?.split(" ")?.get(1) ?: ""
                Glide.with(this).load(it.current?.weather_icons?.get(0)).into(MVVMbinding.imageView)
            }
        })

    }
}