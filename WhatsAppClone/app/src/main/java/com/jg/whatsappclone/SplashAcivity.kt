package com.jg.whatsappclone

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashAcivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash_acivity)


        var shared = getSharedPreferences("MY_PREF", MODE_PRIVATE)

        Log.d("LOGIN DATA from Splash" ,shared.getBoolean("IS_LOGIN",false).toString())
        Log.d("LOGIN USER from Splash" ,shared.getString("FIRST_USER_EMAIL","NOT FOUND").toString())

        Handler().postDelayed(Runnable {

            if(shared.getBoolean("IS_LOGIN",false) == true) //  if login
            {
                startActivity(Intent(this,CameraActivity::class.java))
            }else // not login
            {
                startActivity(Intent(this, UserOneActivity::class.java))
            }
            finish()
        },3000)

    }
}