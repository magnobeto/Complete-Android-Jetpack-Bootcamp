package com.example.notiricationdemo

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.notiricationdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val channelID = "com.example.notiricationdemo.channel1"
    private var notificationManager: NotificationManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        createNotificationChannel(channelID, "DemoChannel", "this is demo")

        binding.button.setOnClickListener {
            displayNotification()
        }
    }

    private fun displayNotification() {
        val notificatioId = 45
        val tapResultIntent = Intent(this, SecondActivity::class.java)
        val pendingIntent: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            tapResultIntent,
            setupPendingIntentFlag()
        )

        // action button 1
        val intent2 = Intent(this, DetailsActivity::class.java)
        val pendingIntent2: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent2,
            setupPendingIntentFlag()
        )
        val action2: NotificationCompat.Action =
            NotificationCompat.Action.Builder(0, "Details", pendingIntent2).build()

        // action button 2
        val intent3 = Intent(this, SettingsActivity::class.java)
        val pendingIntent3: PendingIntent = PendingIntent.getActivity(
            this,
            0,
            intent3,
            setupPendingIntentFlag()
        )
        val action3: NotificationCompat.Action =
            NotificationCompat.Action.Builder(0, "Settings", pendingIntent3).build()
        val notification = NotificationCompat.Builder(this, channelID)
            .setContentTitle("DemoTitle")
            .setContentText("This is a demo notification")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .addAction(action2)
            .addAction(action3)
            .build()
        notificationManager?.notify(notificatioId, notification)
    }

    private fun createNotificationChannel(id: String, name: String, channelDescription: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(id, name, importance).also {
                it.description = channelDescription
            }
            notificationManager?.createNotificationChannel(channel)
        }
    }

    private fun setupPendingIntentFlag(): Int {
        return if (Build.VERSION.SDK_INT >= 31) {
            PendingIntent.FLAG_IMMUTABLE
        } else {
            PendingIntent.FLAG_UPDATE_CURRENT
        }
    }
}