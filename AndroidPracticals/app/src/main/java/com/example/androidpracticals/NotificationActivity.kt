package com.example.androidpracticals

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.androidpracticals.databinding.ActivityNotificationBinding
import kotlin.system.measureNanoTime

class NotificationActivity : AppCompatActivity() {

    private lateinit var binding  : ActivityNotificationBinding

    var channel_ID = "Channel_ID"
    var channel_Name = "Channel_Name"
    var notification_ID = 0

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNotificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick.setOnClickListener {

            var notification = NotificationCompat.Builder(this,channel_ID)
                .setContentTitle("Hello Title")
                .setContentText("This is Content Text")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .build()

            var notificationManager = NotificationManagerCompat.from(this)
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                var channel = NotificationChannel(channel_ID,channel_Name,NotificationManager.IMPORTANCE_DEFAULT).apply {
                    lightColor = Color.GREEN
                    enableLights(true)
                }
                val manager  = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                manager.createNotificationChannel(channel)
            }
            notificationManager.notify(notification_ID,notification)
        }

    }

}