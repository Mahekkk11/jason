package com.example.androidpracticals

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpracticals.databinding.ActivityGridViewBinding

class GridViewActivity : AppCompatActivity() {

    private lateinit var binding : ActivityGridViewBinding

    private  var arraylist : ArrayList<DataItem>? = null
    private lateinit var adapter : GridAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGridViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        arraylist = ArrayList()
        arraylist = (setData())
        adapter = GridAdapter(this,arraylist!!)
        binding.gridView.adapter = adapter
    }

   private fun setData(): ArrayList<DataItem>{
        var arrayData : ArrayList<DataItem> = ArrayList()
        arrayData.add(DataItem(R.drawable.alert_dark_frame))
        return arrayData
    }

}