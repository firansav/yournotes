package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.Manifest
import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_notes.view.*

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteHolder>() {
    private var notes: List<Notes> = ArrayList()
    private val PERMISSION_CODE = 1001

    class NoteHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recyclerview_notes, parent, false)
        return NoteHolder(view)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote = notes[position]
        holder.view.note_image.setImageURI(Uri.parse(currentNote.image))
        holder.view.name.text = currentNote.title
        holder.view.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(MainFragmentDirections.actionMainFragmentToDetailNote().setId(position))
        }
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNotes(notes: List<Notes>) {
        this.notes = notes
        notifyDataSetChanged()
    }
}