package com.example.otptask

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.otptask.databinding.ActivityLoginBinding
import com.example.otptask.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.statusBarColor = Color.TRANSPARENT

        val spannable = SpannableString("Don't have Account ? Click here")
        spannable.setSpan(
            ForegroundColorSpan(ContextCompat.getColor(this,R.color.navyBlue)),
            21, // start
            31, // end
            Spannable.SPAN_EXCLUSIVE_INCLUSIVE
        )
        binding.txtRegister.text = spannable


        binding.txtRegister.setOnClickListener {
        }

    }


}