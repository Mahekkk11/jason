package com.jg.firstmca

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.firstmca.databinding.ActivityRegisterBinding
import com.jg.firstmca.databinding.ActivityShareIntentBinding

class ShareIntentActivity : AppCompatActivity() {

    private lateinit var shareBinding : ActivityShareIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        shareBinding = ActivityShareIntentBinding.inflate(layoutInflater)
        setContentView(shareBinding.root)

        shareBinding.btnShare.setOnClickListener {

         //  var  shareIntent =

            startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE),123)
        }

    }
}