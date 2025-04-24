package com.qor7.mpo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class SplashActivity : AppCompatActivity() {

    private lateinit var runnable: Runnable
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
        window.statusBarColor = ContextCompat.getColor(this, R.color.colorStatusBarTransparent)

        initialization()

    }

    private fun initialization() {
        handler = Handler()
        runnable = Runnable {

            /*  if (Pref.getBooleanValue(Pref.PREF_IS_LOGIN, false)) {
                  startActivity(Intent(this@SplashActivity, MainActivity::class.java))
              } else {
                  startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
              }*/

            startActivity(Intent(this@SplashActivity, WelcomeActivity::class.java))
            finish()
        }
        handler.postDelayed(runnable, 3000)
    }
}