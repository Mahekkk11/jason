package com.jg.onlinelecture

import android.content.DialogInterface
import android.os.Bundle
import android.service.autofill.OnClickAction
import android.view.View.OnClickListener
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.onlinelecture.databinding.ActivityDialogBinding
import com.jg.onlinelecture.databinding.ActivityMainBinding

class DialogActivity : AppCompatActivity() {

    private lateinit var dialogBinding : ActivityDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        dialogBinding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(dialogBinding.root)


        dialogBinding.btnDialog.setOnClickListener {

            var show = AlertDialog.Builder(this)
            show.setIcon(R.drawable.delete)
            show.setTitle("Delete")
            show.setMessage("Your item is Deleted...!")
            show.setPositiveButton("", DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
                Toast.makeText(this,"Your clicked on Positive Button",Toast.LENGTH_LONG).show()
            })
            show.setNegativeButton("Cancel", DialogInterface.OnClickListener{dialog,which->
                Toast.makeText(this,"Your clicked on Negative Button",Toast.LENGTH_LONG).show()
                dialog.cancel()
            })
            var build = show.create()
            build.setCancelable(false)
            build.show()

        }

    }
}