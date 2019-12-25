package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes;

import android.app.AlarmManager
import android.app.Notification
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat

class SplashScreenActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT:Long = 5000
    private val notificationChannelId = "10001"
    private val defaultNotificationChannelId = "default"
    private val delay:Long = 10000
    private val delay2:Long = 60000


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        scheduleNotification(getNotification(getString(R.string.notification)), delay)
        scheduleNotification(getNotification(getString(R.string.recurring_notif)), delay2)

        Handler().postDelayed({
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)
    }

    private fun scheduleNotification(notification: Notification, delay : Long) {
        val notificationIntent = Intent(this, NotificationHelper::class.java)
        notificationIntent.putExtra(NotificationHelper.NOTIFICATION_ID, 1)
        notificationIntent.putExtra(NotificationHelper.NOTIFICATION, notification)
        val pendingIntent = PendingIntent.getBroadcast(
            this,
            0,
            notificationIntent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        val futureInMillis = SystemClock.elapsedRealtime() + delay
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent)
    }

    private fun getNotification(content: String): Notification {
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(application)
            .addNextIntent(intent)
            .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)

        val builder = NotificationCompat.Builder(this, defaultNotificationChannelId)
        builder.setContentTitle("YourNotes")
        builder.setContentText(content)
        builder.setSmallIcon(R.drawable.icon_128)
        builder.setAutoCancel(true)
        builder.setChannelId(notificationChannelId)
        builder.setContentIntent(pendingIntent)
        return builder.build()
    }
}