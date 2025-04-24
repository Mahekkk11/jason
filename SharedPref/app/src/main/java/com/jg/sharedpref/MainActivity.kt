package com.jg.sharedpref

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jg.sharedpref.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        var sharepref : SharedPreferences = this.getSharedPreferences("EMP_PREF", MODE_PRIVATE)
//
//
//        var animation = AnimationUtils.loadAnimation(this,R.anim.alpha)
//        binding.txtAnim.startAnimation(animation)
//        Handler().postDelayed(Runnable {
//            startActivity(Intent(this,HomeActivity::class.java))
//        },3000)

//        binding.btnClick.setOnClickListener {
//            var animation = AnimationUtils.loadAnimation(this, R.anim.alpha)
//            binding.txtAnim.startAnimation(animation)
//        }


    }
}