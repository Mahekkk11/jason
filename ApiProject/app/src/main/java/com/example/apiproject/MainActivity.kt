package com.example.apiproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.apiproject.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    //var BASE_URL = "https://simplifiedcoding.net/demos/"
    var BASE_URL = "https://simplifiedcoding.net/demos/"

    lateinit var adapterDemo: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var manager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.rvView.setHasFixedSize(true)
        binding.rvView.layoutManager = manager

        getData()
    }



    private fun getData()
    {
        var retrofitBuilder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL).build()
            .create(MyApiInterface::class.java)

        var retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataItem>?> {
            override fun onResponse(
                call: Call<List<MyDataItem>?>,
                response: Response<List<MyDataItem>?>
            ) {

                Log.d("Respose>>.....", response.body().toString())

                var data = response.body()!!
                adapterDemo = MyAdapter(baseContext, data)
                binding.rvView.adapter = adapterDemo

            }

            override fun onFailure(call: Call<List<MyDataItem>?>, t: Throwable) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
                Log.e("error", t.toString())
            }
        })
        }




}