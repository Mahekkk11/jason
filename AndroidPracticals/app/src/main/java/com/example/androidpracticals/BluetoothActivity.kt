package com.example.androidpracticals

import android.bluetooth.BluetoothAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.androidpracticals.databinding.ActivityBluetoothBinding

class BluetoothActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBluetoothBinding

    private lateinit var ba : BluetoothAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        binding = ActivityBluetoothBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        var videopath = "android.resource://"+packageName+"/"+R.raw.demo
//        // resource from the videoUrl
//        val uri = Uri.parse(videopath)
//        // sets the resource from the
//        // videoUrl to the videoView
//        binding.videoView.setVideoURI(uri)
//        // creating object of
//        // media controller class
//        val mediaController = MediaController(this)
//        // sets the anchor view
//        // anchor view for the videoView
//        mediaController.setAnchorView(binding.videoView)
//        // sets the media player to the videoView
//        mediaController.setMediaPlayer(binding.videoView)
//        // sets the media controller to the videoView
//        binding.videoView.setMediaController(mediaController)
//        // starts the video
//        binding.videoView.start()

        }

    }
