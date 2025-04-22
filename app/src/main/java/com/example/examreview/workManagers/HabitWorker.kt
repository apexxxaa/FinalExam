package com.example.examreview.workers

import android.Manifest
import android.content.Context
import androidx.annotation.RequiresPermission
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.examreview.R

class HabitWorker(appContext: Context, workerParams: WorkerParameters) : Worker(appContext, workerParams) {

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    override fun doWork(): Result {
        sendHabitReminder(applicationContext)
        return Result.success()
    }

    @RequiresPermission(Manifest.permission.POST_NOTIFICATIONS)
    private fun sendHabitReminder(context: Context) {
        val notification = NotificationCompat.Builder(context, "habit_channel")
            .setContentTitle("Habit Reminder")
            .setContentText("Don't forget to log your habit today!")
            .setSmallIcon(R.drawable.ic_launcher_foreground)  // Use your app's icon here
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        NotificationManagerCompat.from(context).notify(1, notification)
    }
}
