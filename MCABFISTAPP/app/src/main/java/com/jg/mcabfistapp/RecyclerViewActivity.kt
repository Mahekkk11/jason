package com.jg.mcabfistapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.jg.mcabfistapp.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var rvBinding : ActivityRecyclerViewBinding
    private lateinit var userAdapter : UserAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        rvBinding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(rvBinding.root)


        var list = ArrayList<UserData>()

        var list1 = java.util.ArrayList<UserData>()
        list1.add(UserData("MCA","Hello MCA",R.drawable.baseline_adb_24))
        list1.add(UserData("MCA 2","Hello MCA2",R.drawable.baseline_call_24))
        list1.add(UserData("MCA 3","Hello MCA3",R.drawable.baseline_adb_24))
        list1.add(UserData("MCA 4","Hello MCA4",R.drawable.baseline_call_24))
        list1.add(UserData("MCA 5","Hello MCA5",R.drawable.baseline_adb_24))
        list.addAll(list1)


        userAdapter = UserAdapter(this@RecyclerViewActivity,list)
        rvBinding.rvUserName.layoutManager = LinearLayoutManager(this)
        rvBinding.rvUserName.adapter = userAdapter


    }
}