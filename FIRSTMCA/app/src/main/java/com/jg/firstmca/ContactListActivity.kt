package com.jg.firstmca

import android.content.ContentResolver
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.database.getStringOrNull
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import com.jg.firstmca.databinding.ActivityContactListBinding

class ContactListActivity : AppCompatActivity() {

    private lateinit var contactBinding : ActivityContactListBinding

    private lateinit var listContact : ArrayList<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        contactBinding = ActivityContactListBinding.inflate(layoutInflater)
        setContentView(contactBinding.root)

        getContact()

        contactBinding.listContact.setOnItemClickListener { parent, view, position, id ->

            var contact = listContact[position]

            Toast.makeText(this,contact,Toast.LENGTH_LONG).show()

            var callIntent = Intent(Intent.ACTION_CALL)
            callIntent.setData(Uri.parse("tel:$contact"))
            startActivity(callIntent)
        }
    }


    private fun getContact() {

        listContact = java.util.ArrayList()

        val contentresolver: ContentResolver = contentResolver

        val cursur = contentresolver.query(
            ContactsContract
                .Contacts.CONTENT_URI, null, null, null, null
        )
        cursur?.use {
            while (it.moveToNext()) {
                val id = it.getString(
                    it.getColumnIndexOrThrow(ContactsContract.Contacts._ID)
                )
                val name = it.getString(
                    it.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME))

                Log.d("CONTACT DETAILS >>>>>>>>>>>>>>>", id.toString())
                Log.d("CONTACT DETAILS >>>>>>>>>>>>>>>", name.toString())

                if(it.getInt(it.getColumnIndexOrThrow(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0)
                {
                    var phone = contentresolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID+" =? ",
                        arrayOf(id),null)
                    Log.d("CONTACT PHONE >>>>>>>>>>>>>>>", phone.toString())

                    phone?.use {data ->
                        while (data.moveToNext()) {
                            var number =
                                data.getString(data.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            // var number = data.getString(data.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            var contentInfo = "$id" + "$name" + "$number"
                            Log.d("CONTACT DETAILS >>>>>>>>>>>>>>>", contentInfo)


                            listContact.add(number)
                        }

                        var contactAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listContact)
                        contactBinding.listContact.adapter = contactAdapter
                        contactAdapter.notifyDataSetChanged()
                    }
                }else{
                    Log.d("CONTACT DETAILS >>>>>>>>>>>>>>>","Contact has no phone number")
                }
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        getContact()
    }



}