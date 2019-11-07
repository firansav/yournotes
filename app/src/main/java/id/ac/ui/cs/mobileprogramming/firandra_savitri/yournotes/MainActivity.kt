package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Activity
import android.app.AlarmManager
import android.app.Notification
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.os.SystemClock
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

class MainActivity : AppCompatActivity() {

    private val ADD_NOTE_REQUEST = 1
    private lateinit var noteViewModel: NotesViewModel
    private val adapter = NotesAdapter()

    private val notificationChannelId = "10001"
    private val defaultNotificationChannelId = "default"
    private val delay = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        scheduleNotification(getNotification(getString(R.string.notification)))

//        fab.setOnClickListener { view ->
//            startActivityForResult(
//                Intent(this, CreateNoteActivity::class.java),
//                ADD_NOTE_REQUEST
//            )
//        }

//        notes_rv.layoutManager = GridLayoutManager(this, 2)
//        notes_rv.adapter = adapter
//
//        noteViewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
//        noteViewModel .getAllNotes().observe(this,
//            Observer<List<Notes>> { t -> adapter.setNotes(t!!) })

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == ADD_NOTE_REQUEST && resultCode == Activity.RESULT_OK) {
//            val newNote = Notes(
//                data!!.getStringExtra(CreateNoteActivity.EXTRA_TITLE),
//                data.getStringExtra(CreateNoteActivity.EXTRA_DESCRIPTION)
//            )
//            noteViewModel.insert(newNote)
//
//            Toast.makeText(this, "Note saved!", Toast.LENGTH_SHORT).show()
//        } else {
//            Toast.makeText(this, "Note not saved!", Toast.LENGTH_SHORT).show()
//        }
//
//
//    }

    private fun scheduleNotification(notification: Notification) {
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
        builder.setSmallIcon(R.drawable.notes_icon)
        builder.setAutoCancel(true)
        builder.setChannelId(notificationChannelId)
        builder.setContentIntent(pendingIntent)
        return builder.build()
    }
}
