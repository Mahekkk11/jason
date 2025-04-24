package com.example.myapplication

import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Audio.Media
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityCameraBinding


class CameraActivity : AppCompatActivity() {

    var image_uri: Uri? = null
    val IMAGE_CAPTURE_CODE = 654

    private lateinit var binding : ActivityCameraBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
           openCamera()
        }

        binding.buttonShare.setOnClickListener {

            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,"Hello please follow this steps to open Share intent")
            intent.type = ("text/plain")
            startActivity(intent)
        }
    }

    private fun openCamera() {
        val values = ContentValues()
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        startActivityForResult(cameraIntent, IMAGE_CAPTURE_CODE)
    }

    private fun camera()
    {
        val values = ContentValues()
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values)
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT,image_uri)
        startActivityForResult(intent,IMAGE_CAPTURE_CODE)



        var values1 = ContentValues()
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values1)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == IMAGE_CAPTURE_CODE && resultCode == RESULT_OK) {
//            binding.imageView.setImageURI(image_uri)
//        }
//    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_CAPTURE_CODE && resultCode == RESULT_OK)
        {
            binding.imageView.setImageURI(image_uri)
        }
    }

}