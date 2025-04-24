package com.jg.mcabfistapp

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.View.OnLongClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.jg.mcabfistapp.databinding.ActivitySnackBarBinding

class SnackBarActivity : AppCompatActivity() {

    private lateinit var snackbarBinding : ActivitySnackBarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        snackbarBinding = ActivitySnackBarBinding.inflate(layoutInflater)
        setContentView(snackbarBinding.root)

        snackbarBinding.btnClickHere.setOnClickListener {

        var snackbar = Snackbar.make(snackbarBinding.main,"Hello",Snackbar.LENGTH_LONG)
        snackbar.setBackgroundTint(Color.RED)
            snackbar.setTextColor(Color.GREEN)
            snackbar.setAction("Click Here", View.OnClickListener {
                //Login on Click Action for change button name
                if(snackbarBinding.btnClickHere.text == "Submit"){
                    snackbarBinding.btnClickHere.text = "Click Here"}
                else
                {
                    snackbarBinding.btnClickHere.text = "Submit"
                }
            })
            snackbar.show()
        }
    }
}