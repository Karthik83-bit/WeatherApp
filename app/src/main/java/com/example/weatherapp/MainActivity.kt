package com.example.weatherapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mvvmapicall.MVVMActivity

import com.example.weatherapp.databinding.ActivityMainBinding
//import com.example.weathermainapp.WeatherActivity

//32e1631dd7b8a986854389006d95a23c

class MainActivity : AppCompatActivity() {
    private lateinit var Binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        Binding= ActivityMainBinding.inflate(layoutInflater)
        Binding.button.setOnClickListener {
            startActivity(Intent(it.context,MVVMActivity::class.java))
        }
//        Binding.mvvm.setOnClickListener {
//            startActivity(Intent(it.context,MVVMActivity::class.java))
//        }
        setContentView(Binding.root)

    }
}