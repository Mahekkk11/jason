package com.example.androidpracticals

import android.annotation.SuppressLint
import android.content.ContentValues
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.CursorAdapter
import android.widget.Toast
import com.example.androidpracticals.databinding.ActivityDataBaseDemoBinding

class DataBaseDemo : AppCompatActivity() {


    private lateinit var binding : ActivityDataBaseDemoBinding



    var cursor :Cursor? = null
    private var data : ArrayList<UserInfo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDataBaseDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var helper  = MyDBHelper(applicationContext)
        var db = helper.readableDatabase

        var rs = db.rawQuery("SELECT * FROM USERS",null)

        binding.btnClick.setOnClickListener {
            var values = ContentValues()
            values.put("UNAME",binding.edtName.text.toString())
            values.put("PASS",binding.edtPass.text.toString())
            db.insert("USERS",null,values)
        }

        binding.btnShow.setOnClickListener {
            if(rs.moveToNext())
            {
                binding.edtName.setText(rs.getString(1).toString())
                binding.edtPass.setText(rs.getString(2).toString())
            }
        }
    }
}