package com.jg.firstmca

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

        var sharedPref : SharedPreferences = this.getSharedPreferences("MCA_PREF", MODE_PRIVATE)

        Handler().postDelayed(kotlinx.coroutines.Runnable {

            if(sharedPref.getBoolean("IS_LOGIN",false) == true)
            {
                startActivity(Intent(this,HomeActivity::class.java))
            }else {
                startActivity(Intent(this, RegisterActivity::class.java))
            }
            finish()
        },3000)



    }
}