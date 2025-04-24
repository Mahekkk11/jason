package com.jg.mcabfistapp

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.mcabfistapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var homeBinding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        homeBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(homeBinding.root)

        var user : Array<String> = arrayOf("User1","user2","User1",
            "user2","User1","user2","User1","user2","User1",
            "user2","User1","user2","User1","user2","User1",
            "user2","User1","user2","User1","user2","User1",
            "user2","User1","user2","User1","user2","User1",
            "user2","User1","user2","User1","user2","user3")

        var listAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,user)

        homeBinding.lvUserName.adapter = listAdapter
    }
}