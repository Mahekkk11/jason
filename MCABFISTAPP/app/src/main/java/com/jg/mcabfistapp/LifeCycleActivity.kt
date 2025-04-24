package com.jg.mcabfistapp

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LifeCycleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_life_cycle)

        Log.d("TAG","OnCreate Method Called..!")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG","onStart Method Called..!")
    }
    override fun onResume() {
        super.onResume()
        Log.d("TAG","onResume Method Called..!")
    }
    override fun onPause() {
        super.onPause()
        Log.d("TAG","onPause Method Called..!")
    }
    override fun onStop() {
        super.onStop()
        Log.d("TAG","onStop Method Called..!")
    }
    override fun onRestart() {
        super.onRestart()
        Log.d("TAG","onRestart Method Called..!")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG","onDestroy Method Called..!")
    }
}