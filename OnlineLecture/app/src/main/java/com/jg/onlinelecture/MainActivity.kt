package com.jg.onlinelecture


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.jg.onlinelecture.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(),OnClickListener {

    private lateinit var mainBinding : ActivityMainBinding
    private lateinit var personAdapter : PersonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        val personData = ArrayList<PersonDataModel>()

        val person = ArrayList<PersonDataModel>()

        for(i in 1..5)
        {
            person.add(PersonDataModel(R.drawable.notification,"Nil","Mevada"))
        }

        personData.addAll(person)

mainBinding.txtDemo.setOnClickListener {
    val result = mainBinding.txtDemo.text.toString()
    val intent = Intent()
    intent.putExtra("result", result)
    setResult(Activity.RESULT_OK, intent)
    finish()
}


        personAdapter = PersonAdapter(this,personData,this)

        mainBinding.rvUserList.layoutManager = LinearLayoutManager(this,)
        mainBinding.rvUserList.adapter = personAdapter

    }

    override fun onClick(v: View) {

    }
}

