package com.qor7.mpo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_explore_product.*

class ExploreProductActivity : AppCompatActivity(),View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_explore_product)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = ContextCompat.getColor(this@ExploreProductActivity, R.color.colorWhite)

        initialization()
    }

    private fun initialization() {


        btnExploreOtherProduct.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.btnExploreOtherProduct -> {
                startActivity(Intent(this@ExploreProductActivity,MainActivity::class.java))
                finishAffinity()
            }
        }
    }

}