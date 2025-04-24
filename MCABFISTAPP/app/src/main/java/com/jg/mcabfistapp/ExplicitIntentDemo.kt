package com.jg.mcabfistapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.mcabfistapp.databinding.ActivityExplicitIntentDemoBinding

class ExplicitIntentDemo : AppCompatActivity() {

    private lateinit var explicitBinding : ActivityExplicitIntentDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        explicitBinding = ActivityExplicitIntentDemoBinding.inflate(layoutInflater)
        setContentView(explicitBinding.root)


        explicitBinding.btnClickMe.setOnClickListener {
            startActivity(Intent(this,CallActivity::class.java))
        }
    }
}