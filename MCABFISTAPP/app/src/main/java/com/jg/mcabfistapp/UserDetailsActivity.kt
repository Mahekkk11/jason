package com.jg.mcabfistapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.mcabfistapp.databinding.ActivityUserDetailsBinding

class UserDetailsActivity : AppCompatActivity() {

    private lateinit var userDetailsBiding : ActivityUserDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        userDetailsBiding = ActivityUserDetailsBinding.inflate(layoutInflater)
        setContentView(userDetailsBiding.root)

        userDetailsBiding.imgUser.setImageResource(intent.getIntExtra("IMG",0))
        userDetailsBiding.txtFName.text = intent.getStringExtra("FNAME")
        userDetailsBiding.txtUserMessage.text = intent.getStringExtra("MSG")

    }
}

