package com.jg.firstmca

import android.os.Bundle
import android.service.autofill.UserData
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.firstmca.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvBinding : ActivityRecyclerViewBinding
    private lateinit var userAdapter : UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        rvBinding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(rvBinding.root)


        var list : ArrayList<UserData>

        var list1 = java.util.ArrayList<UserData>()



    }
}