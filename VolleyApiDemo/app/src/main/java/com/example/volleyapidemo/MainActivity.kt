package com.example.volleyapidemo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volleyapidemo.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var url = "https://jsonplaceholder.typicode.com/users/"

        var nameArray : ArrayList<String> = ArrayList()
        val postRequest = object :  StringRequest(
            Request.Method.POST, url,
            Response.Listener<String> { response ->
                Log.d("TAG>>>>>>>>>>>>>>>>",response)
                try {

                    val jsonarray = JSONArray(response)

                    for (i in 0 until jsonarray.length()) {
                        val jsonobject = jsonarray.getJSONObject(i)
                        val id = jsonobject.getString("id")
                        val title = jsonobject.getString("name")
                        val company = jsonobject.getString("username")
                        val category = jsonobject.getString("email")
                    }

                    Log.d("TAG>>>>>>>>>>>>>>>>>>>>>>",jsonarray.toString())
//                    var jsonArray = JSONArray(response)
//                    var jsonObject = jsonArray.getJSONObject(1)
//                    var name : String = jsonObject.getString("name")
//                    nameArray.add(name)
//
//                    Log.d("TAG>>>>>>>>>>>>>>>>",nameArray.toString())
//
//                    var arrayAdapter : ArrayAdapter<String> =
//                        ArrayAdapter(this,android.R.layout.simple_list_item_2,nameArray)
//                    binding.listView.adapter = arrayAdapter
                }catch (a : JSONException)
                {
                        a.printStackTrace()
                }


             //   Toast.makeText(this, response, Toast.LENGTH_SHORT).show()
            }, Response.ErrorListener {
                Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show()
            }) {
        }

        var requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(postRequest)

    }


}