package com.example.androidpracticals

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.TextView

class MyBroadcast(val text : TextView) : BroadcastReceiver(){
    override fun onReceive(context: Context?, intent: Intent?) {

        var battery =  intent!!.getIntExtra("level" ,0)
        text.text =
            if(battery > 0)
              battery.toString()
            else ""

     }

}