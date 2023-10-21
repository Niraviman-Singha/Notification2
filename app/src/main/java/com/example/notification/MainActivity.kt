package com.example.notification

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import com.example.notification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding:ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.highBtn.setOnClickListener {
            val notification = NotificationCompat.Builder(this,App().CHANNEL_ID1)
            notification.setContentTitle(binding.titleET.text.toString())
            notification.setContentTitle(binding.contentET.text.toString())
            intent.putExtra("Nir",binding.contentET.text.toString())
            val pendingIntent =
                PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_MUTABLE)

            notification.setSmallIcon(R.drawable.high)
            notification.setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.MAGENTA)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.high,"Back",pendingIntent)
                .addAction(R.drawable.high,"Play",pendingIntent)
                .addAction(R.drawable.high,"Next",pendingIntent)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(1,notification.build())

        }

        binding.lowBtn.setOnClickListener {
            val pendingIntent =
                PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_MUTABLE)

            val notification = NotificationCompat.Builder(this,App().CHANNEL_ID2)
            notification.setContentTitle(binding.titleET.text.toString())
            notification.setContentTitle(binding.contentET.text.toString())

            notification.setSmallIcon(R.drawable.low)

            notification.setPriority(NotificationCompat.PRIORITY_LOW)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.MAGENTA)
                .setContentIntent(pendingIntent)
                .addAction(R.drawable.low,"Back",pendingIntent)
                .addAction(R.drawable.low,"Play",pendingIntent)
                .addAction(R.drawable.low,"Next",pendingIntent)
                .setOnlyAlertOnce(true)
                .setAutoCancel(true)
                .build()

            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.notify(2,notification.build())


        }
    }
}