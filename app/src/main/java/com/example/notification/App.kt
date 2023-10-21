package com.example.notification

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build

class App : Application() {
    final public val CHANNEL_ID1 = "CHANNEL_ID1"
    final public val CHANNEL_ID2 = "CHANNEL_ID2"

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel1 = NotificationChannel(CHANNEL_ID1,"Channel 1",NotificationManager.IMPORTANCE_HIGH)
            channel1.description = "This my High importance notification"

            val channel2 = NotificationChannel(CHANNEL_ID2,"Channel 2",NotificationManager.IMPORTANCE_DEFAULT)
            channel2.description = "This my low importance notification"

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel1)
            manager.createNotificationChannel(channel2)
        }
    }
}