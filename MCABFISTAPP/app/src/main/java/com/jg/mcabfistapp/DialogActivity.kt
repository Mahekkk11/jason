package com.jg.mcabfistapp

import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.mcabfistapp.databinding.ActivityDialogBinding

class DialogActivity : AppCompatActivity() {

    private lateinit var dialogBinding : ActivityDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        dialogBinding = ActivityDialogBinding.inflate(layoutInflater)
        setContentView(dialogBinding.root)

        dialogBinding.btnClick.setOnClickListener {

            var show = AlertDialog.Builder(this)
            show.setIcon(R.drawable.delete)
            show.setTitle("Delete Dialog")
            show.setMessage("Are you sure you want to delete this Data ?")
            show.setPositiveButton("Yes", DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Clicked on Yes",Toast.LENGTH_LONG).show()
            })
            show.setNegativeButton("No",DialogInterface.OnClickListener { dialog, which ->
                Toast.makeText(this,"Clicked on No",Toast.LENGTH_LONG).show()
                dialog.dismiss()
            })
           var dialogShow = show.create()
            dialogShow.setCancelable(false)
            dialogShow.show()
        }


    }
}