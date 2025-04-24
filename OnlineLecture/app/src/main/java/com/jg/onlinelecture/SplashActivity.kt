package com.jg.onlinelecture

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)


       // var shared : SharedPreferences = this.getSharedPreferences("MCAB_PREF", MODE_PRIVATE)

        Handler().postDelayed(Runnable {

//            if(shared.getBoolean("IS_LOGIN",false) == true) {
//                startActivity(Intent(this, CameraActivity::class.java))
//            }else{
//                startActivity(Intent(this, LoginActivtiy::class.java))
//            }
            startActivity(Intent(this, WebDemoActivity::class.java))
        },3000)
    }
}