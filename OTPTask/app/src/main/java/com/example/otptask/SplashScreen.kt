package com.example.otptask

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.statusBarColor = Color.BLACK

        Handler().postDelayed(Runnable {
            startActivity(Intent(this@SplashScreen, LoginActivity::class.java))
            finish()
        }, 2000)


    }
}