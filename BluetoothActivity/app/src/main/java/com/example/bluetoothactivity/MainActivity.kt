package com.example.bluetoothactivity

import android.Manifest
import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.example.bluetoothactivity.databinding.ActivityMainBinding


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var reqEnable: Int = 1
    private var reqDiscover: Int = 2

    private var pairedDevices: Set<BluetoothDevice>? = null
    private lateinit var adapter: BluetoothAdapter

    private var reqCode : Int = 1

    private lateinit var reqIntent :Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = BluetoothAdapter.getDefaultAdapter()

        reqIntent = Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)

        binding.btnOn.setOnClickListener {
            if(!adapter.isEnabled)
            {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        Manifest.permission.BLUETOOTH_CONNECT
                    ) != PackageManager.PERMISSION_GRANTED
                ) {

                    startActivityForResult(reqIntent,reqCode)
                }
                startActivityForResult(reqIntent,reqCode)
            }

        }
        binding.btnOff.setOnClickListener {
            if(adapter.isEnabled)
            {
                adapter.disable()
            }
        }
        binding.btnDis.setOnClickListener {}


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == reqCode)
        {
            if(resultCode == RESULT_OK)
            {
                Toast.makeText(this,"Bluetooth is ON",Toast.LENGTH_LONG).show()
            }else if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this,"Bluetooth Enabled is cancel..",Toast.LENGTH_LONG).show()
            }
        }
    }


}



