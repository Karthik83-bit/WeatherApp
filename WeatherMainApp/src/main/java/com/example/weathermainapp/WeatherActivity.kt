package com.example.weathermainapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.weathermainapp.databinding.ActivityWeatherBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit

class WeatherActivity : AppCompatActivity() {
    private lateinit var WAbinding:ActivityWeatherBinding
    private lateinit var retrofitInst: RetrofitInst
    private lateinit var retrofit:Retrofit
    private lateinit var api:APIMethods
    lateinit var  resp:Response<APIdata>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

WAbinding=ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(WAbinding.root)
        retrofitInst = RetrofitInst()
        retrofit = retrofitInst.getInst()


        WAbinding.button.setOnClickListener {
            Log.d("msg", "kjfjkljdljl")
            api = retrofit.create(APIMethods::class.java)
            val query =
                WAbinding.countryEditText.text.toString() + "," + WAbinding.regEditText.text.toString()
            if (query != null || query != ""){
                GlobalScope.launch(Dispatchers.Main) {
                    resp = api.getRes("58d5a544b53c055f8ef92f15f0a16413", query)
                    if (resp != null) {
                        Log.d("msg", resp.body()?.location.toString())
                        Log.d("msg", resp.body()?.current.toString())
                    }
                    if(!resp.isSuccessful){
                        Toast.makeText(this@WeatherActivity,"Not Valid",Toast.LENGTH_LONG).show()
                    }else {
                        WAbinding.textView.text = resp.body()?.location?.name.toString()
                        WAbinding.tempText.text =
                            resp.body()?.current?.temperature.toString() + "degree celsius"
                        WAbinding.weatherDescText.text =
                            resp.body()?.current?.weather_descriptions.toString()
                        WAbinding.timeText.text =
                            resp.body()?.location?.localtime?.split(" ")?.get(1).toString()
                        Glide.with(this@WeatherActivity)
                            .load(resp.body()?.current?.weather_icons?.get(0))
                            .into(WAbinding.imageView)

                    }
                }
        }
//            WAbinding.textView.text=resp.body()?.current?.humidity.toString()

//
        }


    }

    override fun onStart() {


        super.onStart()


//
//
//        }





    }

}