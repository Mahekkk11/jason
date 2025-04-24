package com.example.drawview

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.drawview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        binding.drawView.setBrushColor(Color.RED)
//
//        binding.btnUndo.setOnClickListener {
//            binding.drawView.undo()
//        }
//
//        binding.btnErase.setOnClickListener {
//            binding.drawView.erase(Color.WHITE)
//        }
//
//        binding.btnRedu.setOnClickListener {
//            binding.drawView.setSizeForBrush(12)
//        }

        binding.btnColor.setOnClickListener {

           // binding.drawView.setBrushColor(Color.BLACK)


            val timer = Integer.parseInt(binding.edtNo.text.toString())

            Thread(Runnable {
                for(i in timer downTo 0)
                {
                    runOnUiThread{

                        if(i%2 == 0)
                        {
                          binding.edtNo.setBackgroundColor(R.color.black)
                        }
                        else{
                            binding.edtNo.setBackgroundColor(R.color.white)
                        }
                        binding.txtNo.text = i.toString()

                    }

                    Thread.sleep(1000)
                }
            }).start()

        }


    }
}