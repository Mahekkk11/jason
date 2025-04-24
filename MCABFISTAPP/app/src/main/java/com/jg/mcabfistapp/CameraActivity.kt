package com.jg.mcabfistapp

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.Images.Media
import android.speech.RecognitionListener
import android.speech.SpeechRecognizer
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.jg.mcabfistapp.databinding.ActivityCameraBinding

class CameraActivity : AppCompatActivity(), RecognitionListener {

    private lateinit var cameraBinding : ActivityCameraBinding

    private lateinit var speechRecognizer: SpeechRecognizer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        cameraBinding = ActivityCameraBinding.inflate(layoutInflater)
        setContentView(cameraBinding.root)


        var shared : SharedPreferences = this.getSharedPreferences("MY_PREF", MODE_PRIVATE)

        cameraBinding.btnCapture.setOnClickListener {
           startActivityForResult(Intent(MediaStore.ACTION_IMAGE_CAPTURE),123)
        }

        cameraBinding.btnGetData.setOnClickListener {
//          //  startActivityForResult(Intent(this,DataActivity::class.java),124)
//
//            var name =  shared.getString("EMAIL","NOT FPUND")
//
//            var user = shared.getInt("IS_LOGIN",0)
//
//            var editor : SharedPreferences.Editor = shared.edit()
//
//            editor.clear()
//
//            Log.d("EMAIL GATTED", name.toString())
//            Log.d("IS_LOGIN GATTED", user.toString())



        }


    }

    override fun onResume() {
        super.onResume()
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
        // You need a listener callback to handle the speech recognition
        speechRecognizer.setRecognitionListener(this)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 123)
        {
            var image = data!!.extras!!["data"] as Bitmap
            cameraBinding.imgImage.setImageBitmap(image)
        }else if(requestCode == 124)
        {
            cameraBinding.txtData.text = data!!.getStringExtra("DATA")
        }

    }

    // Implement the RecognitionListener methods
    override fun onReadyForSpeech(params: Bundle?) {
        Log.d("Speech", "onReadyForSpeech")
    }

    override fun onBeginningOfSpeech() {
        Log.d("Speech", "onBeginningOfSpeech")
    }

    override fun onRmsChanged(rmsdB: Float) {
        // ...
    }

    override fun onBufferReceived(buffer: ByteArray?) {
        // ...
    }

    override fun onEndOfSpeech() {
        Log.d("Speech", "onEndOfSpeech")
    }

    override fun onError(error: Int) {
        Log.e("Speech", "onError: $error")
    }

    override fun onResults(results: Bundle?) {
        val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
        if (!matches.isNullOrEmpty()) {
            val spokenText = matches[0]
            Log.d("Speech", "Results: $spokenText")
            // ... process the spoken text ...
        }
    }

    override fun onPartialResults(partialResults: Bundle?) {
        // ...
    }

    override fun onEvent(eventType: Int, params: Bundle?) {
        // ...
    }
}
