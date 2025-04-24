package com.jg.mcabfistapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.mcabfistapp.databinding.ActivityCallBinding

class CallActivity : AppCompatActivity() {

    private lateinit var callBinding : ActivityCallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        callBinding = ActivityCallBinding.inflate(layoutInflater)
        setContentView(callBinding.root)

        callBinding.btnCall.setOnClickListener {


//
//            var intent : Intent
//            intent = Intent(Intent.ACTION_SEND)
//            intent.setType("text/plain")
//            startActivity(intent)

          //  Toast.makeText(this,"Please check your internet Connection...!",Toast.LENGTH_LONG).show()


        }


    }
}