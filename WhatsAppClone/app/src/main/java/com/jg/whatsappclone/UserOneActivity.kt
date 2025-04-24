package com.jg.whatsappclone

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.whatsappclone.databinding.ActivityUserOneBinding

class UserOneActivity : AppCompatActivity() {

    private lateinit var userOneBinding : ActivityUserOneBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        userOneBinding = ActivityUserOneBinding.inflate(layoutInflater)
        setContentView(userOneBinding.root)

        val shared : SharedPreferences = this.getSharedPreferences("MY_PREF",MODE_PRIVATE)

        val editor : SharedPreferences.Editor = shared.edit()

        userOneBinding.btnUserLogin.setOnClickListener {

            editor.putString("FIRST_USER_EMAIL",userOneBinding.edtEmail.text.toString()) // FIRST_USER_EMAIL is Key to identify the value for Email
            editor.putBoolean("IS_LOGIN",true)

            editor.apply()
            editor.commit()


            Log.d("TAG EMAIL>>>>>",shared.getString("FIRST_USER_EMAIL","NOT FOUND").toString())
            //Log.d("TAG USER>>>>>",shared.getInt("USER_NO",0).toString())

            userOneBinding.edtEmail.text!!.clear()
        }
    }
}
