package com.example.threaddemo

import android.graphics.Color
import android.nfc.Tag
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.threaddemo.databinding.ActivityMainBinding
import kotlinx.coroutines.runInterruptible
import kotlin.math.log


class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textView = findViewById(R.id.txtData)


        binding.hrProgress.visibility = View.INVISIBLE

//        binding.btnSubmit.setOnClickListener {
//
//            val  number = Integer.parseInt(binding.edtno.text.toString())
//
//            binding.btnSubmit.visibility = View.INVISIBLE
//
//
//            Thread(kotlinx.coroutines.Runnable {
//
//                for ( i in number downTo 0)
//                {
//                    runOnUiThread({
//                        binding.txtValue.text  = i.toString()
//                        if(i == 0)
//                        {
//                            binding.btnSubmit.visibility = View.VISIBLE
//                            binding.llMainView.setBackgroundColor(Color.RED)
//                        }
//                        else{
//                            binding.llMainView.setBackgroundColor(Color.GREEN)
//                        }
//
//                    })
//
//                    Thread.sleep(1000)
//                }
//
//            }).start()
//
//        }


        binding.btnClick.setOnClickListener {
            uploadTask()
        }
    }



    private fun uploadTask()
    {
        var demo = Demo()
        demo.execute("Hello")
    }

    class Demo : AsyncTask<String,Void,String>(){

        override fun onPreExecute() {
            super.onPreExecute()
            Log.i("TAG>>>>>>>>","Pre Executed"+Thread.currentThread().name)

        }


        override fun doInBackground(vararg params: String?): String? {

            Log.d("TAG>>>>>>>>",Thread.currentThread().name)
            Log.d("TAG>>>>>>", params[0].toString())

            for(i in 1..10)
            {

              Log.d("TAG",i.toString())
            }


            return null
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.i("TAG>>>>>>>>","Post Executed"+Thread.currentThread().name)
        }

    }
}