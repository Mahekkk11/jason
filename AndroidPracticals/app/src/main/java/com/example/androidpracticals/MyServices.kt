package com.example.androidpracticals

import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.MediaStore.Audio.Media
import android.provider.Settings
import androidx.compose.ui.text.font.FontVariation
import java.security.Provider.Service

class MyServices : android.app.Service() {

    private lateinit var player : MediaPlayer

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this,Settings.System.DEFAULT_RINGTONE_URI)
        player.isLooping = true
        player.start()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}