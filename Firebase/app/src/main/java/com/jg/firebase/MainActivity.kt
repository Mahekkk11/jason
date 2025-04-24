package com.jg.firebase

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
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
import com.google.firebase.database.database
import com.google.firebase.initialize
import com.jg.firebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var dataRef  : DatabaseReference

    var classDemo = DataClass()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSet.setOnClickListener {
            retrieveDataById("9")
            //setData()
        }
        binding.btnGet.setOnClickListener {
           updateData()
        }
    }

    private fun setData()
    {
        dataRef = FirebaseDatabase.getInstance().getReference("Student1")

        val eId = binding.edtID.text.toString()
        val edtFName = binding.edtFName.text.toString()
        val edtLName = binding.edtLName.text.toString()
        val edtNumber = binding.edtNumber.text.toString()

        if(eId.isEmpty() && edtFName.isEmpty() && edtLName.isEmpty() && edtNumber.isEmpty()) {
            Toast.makeText(this,"Please insert ",Toast.LENGTH_LONG).show()
        }
        else{
            var std = DataClass(eId,edtFName,edtLName,edtNumber)

            dataRef.child(eId).setValue(std).addOnSuccessListener {
                Toast.makeText(this,"Data Inserted",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener {
                Toast.makeText(this,"Data Not Inserted",Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun retrieveDataById(id: String) {
        val databaseReference = FirebaseDatabase.getInstance().getReference("Student1")

        databaseReference.child(id).addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    val data = snapshot.getValue(DataClass::class.java)

                    Log.d("DATA>>>>>>>",data?.efname.toString()+data?.elname.toString()+data?.efnumber.toString()+data?.eId.toString())

                    println("Retrieved Data Fname: ${data?.efname}")
                    println("Retrieved Data Lname: ${data?.elname}")
                    println("Retrieved Data Id: ${data?.eId}")

                    binding.edtID.setText(data?.eId.toString())
                    binding.edtFName.setText(data?.efname.toString())
                    binding.edtLName.setText(data?.elname.toString())
                    binding.edtNumber.setText(data?.efnumber.toString())

                }else {
                    println("Data not found for ID: $id")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                println("Error: ${error.message}")
            }
        })
    }


    fun updateData()
    {
        val dataref = FirebaseDatabase.getInstance().getReference("Student1")

        var uderId : String = binding.edtID.text.toString()


        var updateDate = mapOf(
            classDemo.efname to binding.edtFName.text.toString(),
            classDemo.elname to binding.edtLName.text.toString(),
            classDemo.efnumber to binding.edtNumber.text.toString(),
        )

        val mapWithStringKeys = updateDate.mapKeys { it.key.toString() }

        dataref.child(uderId).updateChildren(mapWithStringKeys).addOnCompleteListener{
            if (it.isSuccessful) {
                Toast.makeText(this, "Data updated successfully", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Failed to update data", Toast.LENGTH_SHORT).show()
            }
        }

    }


}