package com.jg.onlinelecture

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.jg.onlinelecture.databinding.ActivityCameraBinding

class CameraActivity : AppCompatActivity() {

    private lateinit var cameraBinding: ActivityCameraBinding

    private val CAMERA_PERMISSION_REQUEST_CODE = 100

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        cameraBinding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(cameraBinding.root)

        cameraBinding.btnCapture.setOnClickListener {
            // startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE), 123)
            //startActivityForResult(Intent(this,MainActivity::class.java),345)
            checkCameraPermission()
        }
    }

    private fun checkCameraPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.CAMERA
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            openCamera()
        } else {
            requestOpenCamera()
        }
    }


//    private fun cameraPermission()
//    {
//        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED)
//        {
//            allow()
//        }
//        else{
//            allowPermission()
//        }
//    }

    private fun requestOpenCamera() {
        ActivityCompat.requestPermissions(
            this, arrayOf(android.Manifest.permission.CAMERA),
            CAMERA_PERMISSION_REQUEST_CODE
        )
    }

//    private fun allowPermission()
//    {
//        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA),CAMERA_PERMISSION_REQUEST_CODE)
//    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == CAMERA_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openCamera()
            } else {
                Toast.makeText(this, "Denied", Toast.LENGTH_LONG).show()
            }
        }
    }

//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
//        if(requestCode == CAMERA_PERMISSION_REQUEST_CODE)
//        {
//            if(grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                // Allow
//                allow()
//            }
//            else{
//                Toast.makeText(this,"Not allowed",Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

//
//    private fun allow()
//    {
//        Toast.makeText(this,"allowed",Toast.LENGTH_SHORT).show()
//        startActivityForResult(
//            Intent(MediaStore.ACTION_IMAGE_CAPTURE),
//            CAMERA_PERMISSION_REQUEST_CODE
//        )
//    }


    private fun openCamera()
    {
        Toast.makeText(this, "Camera permission granted", Toast.LENGTH_SHORT).show()

        startActivityForResult(
            Intent(MediaStore.ACTION_IMAGE_CAPTURE),
            CAMERA_PERMISSION_REQUEST_CODE
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 123)
        {
            var img = data?.extras?.get("data") as Bitmap
           // cameraBinding.imgCapture.setImageBitmap(img)
        }
        else if(requestCode == 345 && resultCode == RESULT_OK)
        {
            var name = data?.getStringExtra("result")
            cameraBinding.txtDemo.text = name
        }
    }
}