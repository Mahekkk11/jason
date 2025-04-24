package com.jg.onlinelecture

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.onlinelecture.databinding.ActivityMainBinding
import com.jg.onlinelecture.databinding.ActivityProductDetailBinding

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var detailsBinding : ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        detailsBinding = ActivityProductDetailBinding.inflate(layoutInflater)
        setContentView(detailsBinding.root)

        var profile = intent.getIntExtra("IMG",0)

       // Log.d("IMAGE>>>>>>", intent.getIntExtra("IMG", 0).toString())
        var fname = intent.getStringExtra("FNAME") as String
        var lname = intent.getStringExtra("LNAME") as String

        detailsBinding.imgProfile.setImageResource(profile)
        detailsBinding.txtUserFName.text = fname
        detailsBinding.txtUserLName.text = lname
    }
}