package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.activity_create_notes.*

class CreateNoteActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "d.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes.EXTRA_TITLE"
        const val EXTRA_DESCRIPTION = "d.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes.EXTRA_DESCRIPTION"
    }

    var id = 0;
    private lateinit var viewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_notes)

        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
//        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)

        button_createnote.setOnClickListener{
            if (addnote_title.text.toString().trim().isBlank() || addnote_description.text.toString().trim().isBlank()) {
                Toast.makeText(this, "Can not insert empty note!", Toast.LENGTH_SHORT).show()
            } else {
                saveNote()

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun saveNote() {

        val newNote = Notes(
            addnote_title.text.toString(),
            addnote_description.text.toString())

        viewModel.insert(newNote)
        Toast.makeText(this, "Note created", Toast.LENGTH_SHORT).show()
    }
}