package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_create_notes.*

class CreateNoteActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "d.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes.EXTRA_TITLE"
        const val EXTRA_DESCRIPTION = "d.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes.EXTRA_DESCRIPTION"
    }

    var id = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_create_notes)
//        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_close)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.button_createnote -> {
                saveNote()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun saveNote() {
        if (addnote_title.text.toString().trim().isBlank() || addnote_description.text.toString().trim().isBlank()) {
            Toast.makeText(this, "Can not insert empty note!", Toast.LENGTH_SHORT).show()
            return
        }

        val data = Intent().apply {
            putExtra(EXTRA_TITLE, addnote_title.text.toString())
            putExtra(EXTRA_DESCRIPTION, addnote_description.text.toString())
        }

        setResult(Activity.RESULT_OK, data)
        finish()
    }
}