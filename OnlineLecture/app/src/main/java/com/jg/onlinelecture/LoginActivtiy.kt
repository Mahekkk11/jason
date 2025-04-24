package com.jg.onlinelecture

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jg.onlinelecture.databinding.ActivityLoginActivtiyBinding

class LoginActivtiy : AppCompatActivity() {
    private lateinit var loginBinding : ActivityLoginActivtiyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        loginBinding = ActivityLoginActivtiyBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)


        var sharedPref : SharedPreferences = this.getSharedPreferences("MCAB_PREF", MODE_PRIVATE)

        var editShared : SharedPreferences.Editor = sharedPref.edit()




        loginBinding.btnLogin.setOnClickListener {
            editShared.putString("EMAIL",loginBinding.edtEmail.text.toString())
            editShared.putBoolean("IS_LOGIN",true)

            editShared.commit()

            Log.d("TAG EMAIL>>>>>>>>>>",sharedPref.getString("EMAIL","NOT FOUND").toString())

            startActivity(Intent(this,CameraActivity::class.java))
        }

    }
}