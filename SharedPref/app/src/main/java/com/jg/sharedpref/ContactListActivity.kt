package com.jg.sharedpref

import android.content.ContentResolver
import android.content.Intent
import android.content.Intent.ACTION_CALL
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.jg.sharedpref.databinding.ActivityContactListBinding

class ContactListActivity : AppCompatActivity() {

    private lateinit var contactBinding: ActivityContactListBinding
    private lateinit var arrayAdapter: ArrayAdapter<String>
    private lateinit var listContact: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        contactBinding = ActivityContactListBinding.inflate(layoutInflater)
        setContentView(contactBinding.root)


        getContact()
//        contactBinding.btnContact.setOnClickListener {
//            getContact()
//        }


        contactBinding.listContact.setOnItemClickListener { parent, view, position, id ->

            var no = listContact[position]

            // Toast.makeText(this,no,Toast.LENGTH_LONG).show()

            var intent = Intent(ACTION_CALL)
            intent.setData(Uri.parse("tel:" + "$no"))
            startActivity(intent)
        }
    }

    private fun getContact() {
        listContact = java.util.ArrayList()
        val contentResolver: ContentResolver = contentResolver
        var query = contentResolver.query(
            ContactsContract.Contacts.CONTENT_URI, null, null, null, null
        )
        query?.use {
            while (it.moveToNext()) {
                var id = it.getString(it.getColumnIndexOrThrow(ContactsContract.Contacts._ID))
                var name =
                    it.getString(it.getColumnIndexOrThrow(ContactsContract.Contacts.DISPLAY_NAME))
                Log.d("Contact ID>>>", id)
                Log.d("Contact Name", name)
                if (it.getInt(it.getColumnIndexOrThrow(ContactsContract.Contacts.HAS_PHONE_NUMBER)) > 0) {
                    var phonequery = contentResolver.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + "=?",
                        arrayOf(id),
                        null
                    )
                    phonequery?.use { data ->
                        while (data.moveToNext()) {
                            var phone =
                                data.getString(data.getColumnIndexOrThrow(ContactsContract.CommonDataKinds.Phone.NUMBER))
                            Log.d("Contact Number >>>>>>>>>>>>>>>", phone)
                            listContact.add(phone)
                        }
                        arrayAdapter =
                            ArrayAdapter(this, android.R.layout.simple_list_item_1, listContact)
                        contactBinding.listContact.adapter = arrayAdapter
                    }
                } else {
                    Log.d("MSG", "Contact not found...!")
                }
            }
        }
    }

    override fun onRestart() {
        super.onRestart()
        getContact()
    }

}