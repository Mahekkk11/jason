package com.jg.mcabfistapp

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.mcabfistapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerBinding : ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        registerBinding.checkTermsCondition.setOnCheckedChangeListener { buttonView, isChecked ->
            if(isChecked)
            {
                registerBinding.btnSubmit.visibility = View.VISIBLE
            }else{
                registerBinding.btnSubmit.visibility = View.GONE
            }
        }

        registerBinding.rgGender.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.rbMale)
            {
                Toast.makeText(this,"Male",Toast.LENGTH_LONG).show()
            }
            else if(checkedId == R.id.rbFemale)
            {
                Toast.makeText(this,"Female",Toast.LENGTH_LONG).show()
            }
        }
    }
}