package com.jg.sharedpref

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.sharedpref.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)


        var shared : SharedPreferences = this.getSharedPreferences("EMP_PREF", MODE_PRIVATE)


        var editor : SharedPreferences.Editor = shared.edit()

        homeBinding.txtUserName.text = "Welcome..."+shared.getString("MY_EMAIL","NOT FOUND")


        homeBinding.btnLogout.setOnClickListener {


            editor.remove("MY_EMAIL")
            editor.remove("MY_LOGIN")
            editor.clear()
            editor.commit()
            finishAffinity()


            startActivity(Intent(this,LoginActivity::class.java))
            finish()

        }


    }
}