package com.jg.navigationdemo

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.navigationdemo.databinding.ActivityAnimationBinding

class AnimationActivity : AppCompatActivity() {

    private lateinit var animBinding: ActivityAnimationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        animBinding = ActivityAnimationBinding.inflate(layoutInflater)
        setContentView(animBinding.root)

        var animation = AnimationUtils.loadAnimation(this,R.anim.alpha)
        animBinding.txtData.startAnimation(animation)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        },3000)

//
//        animBinding.btnRotate.setOnClickListener {
//            var animation = AnimationUtils.loadAnimation(this,R.anim.rotate)
//            animBinding.txtData.startAnimation(animation)
//        }
//        animBinding.btnalpha.setOnClickListener {
//            var animation = AnimationUtils.loadAnimation(this,R.anim.alpha)
//            animBinding.txtData.startAnimation(animation)
//        }
//        animBinding.btntranslate.setOnClickListener {
//            var animation = AnimationUtils.loadAnimation(this,R.anim.translate)
//            animBinding.txtData.startAnimation(animation)
//        }

    }
}








