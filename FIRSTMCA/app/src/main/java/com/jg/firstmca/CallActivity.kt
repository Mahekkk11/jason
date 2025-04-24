package com.jg.firstmca

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.firstmca.databinding.ActivityCallBinding

class CallActivity : AppCompatActivity() {

    private lateinit var callBinding : ActivityCallBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        callBinding = ActivityCallBinding.inflate(layoutInflater)
        setContentView(callBinding.root)

        callBinding.btnCall.setOnClickListener {

           if(callBinding.edtNumber.text!!.isNotEmpty())
           {
               if(callBinding.edtNumber.text!!.length in 10..10)
               {
                   var intent = Intent()
                   intent.setData(Uri.parse("tel:${callBinding.edtNumber.text.toString()}"))
                   startActivity(intent)
               }
               else{
                   Toast.makeText(this,"Please enter valid input",Toast.LENGTH_LONG).show()
               }

           }else{
               Toast.makeText(this,"Enter your contact Number",Toast.LENGTH_LONG).show()
           }
        }

    }
}