package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val ADD_NOTE_REQUEST = 1
    private lateinit var noteViewModel: NotesViewModel
    private val adapter = NotesAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            startActivityForResult(
                Intent(this, CreateNoteActivity::class.java),
                ADD_NOTE_REQUEST
            )
        }

//        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.setHasFixedSize(true)
//        recyclerView.adapter = adapter
//        noteViewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
//        noteViewModel.getAllNotes().observe(this,
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
}
