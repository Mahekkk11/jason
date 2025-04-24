package com.jg.firstmca

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.firstmca.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        var shared : SharedPreferences = this.getSharedPreferences("MCA_PREF", MODE_PRIVATE)

        var editor : SharedPreferences.Editor = shared.edit()



        registerBinding.btnSubmit.setOnClickListener {

            editor.putString("EMAIL",registerBinding.edtEmail.text.toString())
            editor.putBoolean("IS_LOGIN",true)
            editor.commit()


            Log.d("EMAIL GET >>>>>",shared.getString("EMAIL","NOT FOUND").toString())
            Log.d("USER IS LOGIN GET >>>>>",shared.getBoolean("IS_LOGIN",false).toString())
            startActivity(Intent(this,HomeActivity::class.java))
        }

    }
}