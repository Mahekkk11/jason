
package com.example.androidpracticals

import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidpracticals.databinding.ActivityServiceDemoBinding

class ServiceDemoActivity : AppCompatActivity() {

    private lateinit var serviceBinding : ActivityServiceDemoBinding
    private lateinit var myBroadcast: MyBroadcast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        serviceBinding = ActivityServiceDemoBinding.inflate(layoutInflater)
        setContentView(serviceBinding.root)

        myBroadcast = MyBroadcast(serviceBinding.txtBattery)
        registerReceiver(myBroadcast,IntentFilter(Intent.ACTION_BATTERY_CHANGED))

//        serviceBinding.btnStart.setOnClickListener {
//            startService(Intent(this@ServiceDemoActivity,MyServices::class.java))
//        }
//
//        serviceBinding.btnStop.setOnClickListener {
//            stopService(Intent(this@ServiceDemoActivity,MyServices::class.java))
//        }
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(myBroadcast)
    }
}