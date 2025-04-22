package com.example.examreview.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.app.Service.START_STICKY
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import androidx.core.app.ServiceCompat.startForeground
import com.example.examreview.R

class HabitTimerService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

       // createNotificationChannel()

        val notification = NotificationCompat.Builder(this, "habit_channel")
            .setContentTitle("Habit Timer Running")
            .setContentText("Tracking meditation...")
            .setSmallIcon(R.drawable.ic_timer)
            .build()

        startForeground(1, notification)
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

   /* private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "habit_channel",  // Channel ID (must match your NotificationCompat.Builder)
                "Habit Timer Channel", // Name shown in settings
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val manager = getSystemService(NotificationManager::class.java)
            manager.createNotificationChannel(channel)
        }
    }*/
}