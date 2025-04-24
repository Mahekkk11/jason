package com.jg.sharedpref

import android.Manifest
import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.sharedpref.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        var shared : SharedPreferences = this.getSharedPreferences("EMP_PREF", MODE_PRIVATE)

        var sharedUpdate : SharedPreferences.Editor = shared.edit()

        loginBinding.btnLogin.setOnClickListener {

            if(loginBinding.edtEmail.text!!.isNotEmpty() && loginBinding.edtPassword.text!!.isNotEmpty())
            {
                sharedUpdate.putString("MY_EMAIL",loginBinding.edtEmail.text.toString())
                sharedUpdate.putBoolean("MY_LOGIN",true)
                sharedUpdate.commit()

                Toast.makeText(this,"Success",Toast.LENGTH_LONG).show()

                startActivity(Intent(this,HomeActivity::class.java))
                finish()

            }else{
                Toast.makeText(this,"Please enter value..!",Toast.LENGTH_LONG).show()
            }
        }
    }


}