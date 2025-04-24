package com.example.androidpracticals

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.view.animation.BounceInterpolator
import android.view.animation.OvershootInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpracticals.databinding.ActivityAnimationDemoBinding


class AnimationDemoActivity : AppCompatActivity() {

    private lateinit var binding :ActivityAnimationDemoBinding
    private val ANIMATION_DURATION = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityAnimationDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFade.setOnClickListener {
            binding.imgLogo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.fade_anim))
        }
        binding.btnRotate.setOnClickListener {
           var  animator = ObjectAnimator.ofFloat(binding.imgLogo, "translationX", 300f)
            animator.interpolator = BounceInterpolator()
            animator.duration = 2000.toLong()
            animator.start()
        }
        binding.btnBlink.setOnClickListener {
            binding.imgLogo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.blink_anim))
        }
        binding.btnMove.setOnClickListener {
            binding.imgLogo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.move_anim))
        }
        binding.btnZoom.setOnClickListener {
            binding.imgLogo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.zoom_anim))
        }
        binding.btnSlide.setOnClickListener {
            binding.imgLogo.startAnimation(AnimationUtils.loadAnimation(this,R.anim.slide_anim))
        }
    }
}