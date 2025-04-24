package com.example.androidpracticals

import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.Contacts
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.SimpleAdapter
import android.widget.SimpleCursorAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpracticals.databinding.ActivityContactBinding


class ContactActivity : AppCompatActivity() {

    private lateinit var binding : ActivityContactBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        read()

    }

    private fun read()
    {
        //var cursor : Cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)!!
      //  startManagingCursor(cursor)


        var cursor : Cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,null,null,null)!!
        startManagingCursor(cursor)

        var from  = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,ContactsContract.CommonDataKinds.Phone.NUMBER,ContactsContract.CommonDataKinds.Phone._ID)

        var add = intArrayOf(android.R.id.text1,android.R.id.text2)

        var simple : SimpleCursorAdapter = SimpleCursorAdapter(this,android.R.layout.simple_list_item_2,cursor,from,add)
        
        binding.listView.adapter = simple

    }
}