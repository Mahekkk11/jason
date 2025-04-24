package com.jg.firstmca

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import com.jg.firstmca.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

       var userList : Array<String> =
           arrayOf("A","B","C","D",
               "E","F","A","B","C","D","E","F","A","B","C","D","E","F","A","B",
               "C","D","E","F","A","B","C","D","E","F","A","B","C","D","E","F","I")

        var adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,userList)

        homeBinding.lvUser.adapter = adapter

        homeBinding.btnClick.setOnClickListener {

            var snackbar = Snackbar.make(homeBinding.main,"Hello",Snackbar.LENGTH_LONG)
            snackbar.setBackgroundTint(Color.RED)
            snackbar.setTextColor(Color.GREEN)
            snackbar.setAction("Click Here", View.OnClickListener {
                if(homeBinding.btnClick.text == "Submit")
                {
                    homeBinding.btnClick.text = " Click here"
                }
                else {
                    homeBinding.btnClick.text = "Submit"
                }
            })
            snackbar.show()

        }

    }
}