package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteHolder>() {
    private var notes: List<Notes> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_notes_details, parent, false)
        return NoteHolder(itemView)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote = notes[position]
        holder.textViewTitle.text = currentNote.title
        holder.textViewDescription.text = currentNote.content
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    fun setNotes(notes: List<Notes>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTitle: TextView = itemView.findViewById(R.id.notes_title)
        var textViewDescription: TextView = itemView.findViewById(R.id.notes_content)

    }
}