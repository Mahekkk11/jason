package com.jg.mcabfistapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.mcabfistapp.databinding.ActivityAnimDemoBinding

class AnimDemoActivity : AppCompatActivity() {

    private lateinit var animBinding : ActivityAnimDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        animBinding = ActivityAnimDemoBinding.inflate(layoutInflater)
        setContentView(animBinding.root)

        var animation = AnimationUtils.loadAnimation(this,R.anim.rotate)
        animBinding.txtDemo.startAnimation(animation)

        Handler().postDelayed({
            startActivity(Intent(this,HomeActivity::class.java))
        },3000)


//        animBinding.btnRotate.setOnClickListener {
//            var animation = AnimationUtils.loadAnimation(this,R.anim.rotate)
//            animBinding.txtDemo.startAnimation(animation)
//        }
//        animBinding.btnAlpha.setOnClickListener {
//            var animation = AnimationUtils.loadAnimation(this,R.anim.alpha)
//            animBinding.txtDemo.startAnimation(animation)
//        }
//        animBinding.btnTranslate.setOnClickListener {
//            var animation = AnimationUtils.loadAnimation(this,R.anim.translate)
//            animBinding.txtDemo.startAnimation(animation)
//        }
    }
}