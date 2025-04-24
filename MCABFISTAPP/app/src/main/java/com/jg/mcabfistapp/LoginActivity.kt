package com.jg.mcabfistapp

import android.annotation.SuppressLint
import android.content.ComponentName
import android.content.ContentResolver
import android.content.Intent
import android.content.SharedPreferences
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.location.FusedLocationProviderClient
import com.jg.mcabfistapp.databinding.ActivityLoginBinding
import java.util.Locale

class LoginActivity : AppCompatActivity() {

    private lateinit var mainbinding : ActivityLoginBinding

    var list = ArrayList<String>()
    @SuppressLint("MissingPermission")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        mainbinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(mainbinding.root)

        mainbinding.btnLogin.setOnClickListener {
//            println(shared.getString("EMAIL",">>>>>>>>>>>>>>>>NOT FOUND"))
//
//            Log.d("TAG",shared.getString("EMAIL",">>>>>>>>>>>>>>>>NOT FOUND").toString())
            contact()
        }
    }


    private fun contact()
    {
        val contentResolver :ContentResolver = contentResolver

        var cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI,null,null,null,null)

        cursor?.use {
            while(it.moveToNext())
            {
                val id = it.getString(it.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
                val name = it.getString(it.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME))

                if(it.getInt(it.getColumnIndexOrThrow(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0)
                {
                    var phoneNo = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" = ?",
                        arrayOf(id),null)


                    phoneNo?.use {
                        while (it.moveToNext())
                        {
                            var number = it.getString(it.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))

                            var contacr_fetching_data = "$name"+"$number"

                            Log.d("contacr_fetching_data>>>>",contacr_fetching_data)
                        }
                    }
                } else{ Toast.makeText(this,"Not found",Toast.LENGTH_LONG).show() }
            }
        }
    }

    private fun getContacts() {
        val contentResolver: ContentResolver = contentResolver
        val cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)

        cursor?.use {
            while (it.moveToNext()) {
                val id = it.getString(it.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
                val name = it.getString(it.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME))
                if (it.getInt(it.getColumnIndexOrThrow(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    val phoneCursor = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        arrayOf(id),
                        null
                    )

                    phoneCursor?.use { phone ->
                        while (phone.moveToNext()) {
                            val phoneNumber = phone.getString(phone.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            println("Contact: $name (ID: $id), Phone: $phoneNumber")

                            var contactInfo =  "$name"+"$phoneNumber"

                            Log.d("CONTACT List >>>>>>>>>>>>>>>>>>",contactInfo)
                        }
                    }
                } else {
                    println("Contact: $name (ID: $id), No phone number")
                }
                println("Contact#########: $name (ID: $id)")

                //Log.d("CONTACT>>>>>>>>>>>>>>>>>",id + name + phoneNumber)
            }

            //Log.d("CONTACT>>>>>>>>>>>>>>>>>",id + name)
        }
    }

}