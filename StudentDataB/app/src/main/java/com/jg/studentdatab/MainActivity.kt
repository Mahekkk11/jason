package com.jg.studentdatab

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.jg.studentdatab.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnInsertData.setOnClickListener {
           // setData()
            getData("1")
        }
    }


     fun setData()
     {

         var dataRef = FirebaseDatabase.getInstance().getReference("StudData")

         var id = binding.edtRollNo.text.toString()
         var fname = binding.edtFName.text.toString()
         var lname = binding.edtLName.text.toString()

         var  std = StudData(id,fname,lname)

         dataRef.child(id).setValue(std).addOnSuccessListener {
             Toast.makeText(this,"Data Inserted",Toast.LENGTH_LONG).show()

             binding.edtRollNo.setText("")
             binding.edtFName.setText("")
             binding.edtLName.setText("")

         }.addOnFailureListener {
             Toast.makeText(this,"Data Not Inserted",Toast.LENGTH_LONG).show()
         }
     }

    fun retrieveDataById(id: String) {
        val databaseReference = FirebaseDatabase.getInstance().getReference("StudData")

        databaseReference.child(id).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val data = snapshot.getValue(StudData::class.java)

                    Log.d(
                        "DATA>>>>>>>",
                        data?.sId.toString() + data?.sFname.toString() + data?.sLname.toString()
                    )

                    println("Retrieved Data: $data")
                } else {
                    println("Data not found for ID: $id")
                }
            }

            override fun onCancelled(error: DatabaseError) {
                println("Error: ${error.message}")
            }
        })

    }
        fun getData(id:String)
        {

            var getRef = FirebaseDatabase.getInstance().getReference("StudData2")

            getRef.child(id).addListenerForSingleValueEvent(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists())
                    {
                        var data = snapshot.getValue(StudData::class.java)

                        data!!.sId.toString()
                        data!!.sId.toString()
                        data!!.sId.toString()
                    }else{
                        Toast.makeText(this@MainActivity,"Data Not Found",Toast.LENGTH_LONG).show()
                    }
                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@MainActivity,error.toString(),Toast.LENGTH_LONG).show()
                }

            })

        }
    }
