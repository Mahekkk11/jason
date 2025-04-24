package com.example.asynctaskdemo

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.example.asynctaskdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private lateinit var binding : ActivityMainBinding
    private lateinit var texyDemo : TextView

    var name : String? = ""
    var name2 : String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        
        texyDemo = TextView(this)
        texyDemo.findViewById<TextView>(R.id.textDemo)

        binding.btnClick.setOnClickListener {
            var taskDemo = AsyncTaskDemo()
            taskDemo.execute()
        }

    }


  inner class AsyncTaskDemo() : AsyncTask<Void,Void,String>(){

        override fun onPreExecute() {
            super.onPreExecute()
            Log.d("TAG>>>>>>>>>>>","Your Task is ready to run")
            name = "Task is start"
        }

        override fun doInBackground(vararg params: Void?): String {
           for (i in 10 downTo 1)
           {
               Log.d("TAG>>>>>>>>",i.toString())
              name2 = i.toString()
           }
           return ""
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
             Log.d("TAG>>>>>","Your task is finish")

            texyDemo.text = name+name2+"Your task is finish"

        }

    }
}