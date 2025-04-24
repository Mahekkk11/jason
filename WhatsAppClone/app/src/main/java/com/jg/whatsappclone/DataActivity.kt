package com.jg.whatsappclone

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.whatsappclone.databinding.ActivityDataBinding

class DataActivity : AppCompatActivity() {

    private lateinit var dataBinding : ActivityDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        dataBinding = ActivityDataBinding.inflate(layoutInflater)
        setContentView(dataBinding.root)

        dataBinding.btnGetData.setOnClickListener {
            var intent = Intent()
            intent.putExtra("DATA",dataBinding.edtSetData.text.toString())
            setResult(Activity.RESULT_OK,intent)
            finish()
        }
    }
}