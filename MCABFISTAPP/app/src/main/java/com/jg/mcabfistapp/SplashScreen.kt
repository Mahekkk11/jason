package com.jg.mcabfistapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.provider.MediaStore
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed(kotlinx.coroutines.Runnable {
          startActivity(Intent(this,RegisterActivity::class.java))
            finish()
        },3000)

    }
}