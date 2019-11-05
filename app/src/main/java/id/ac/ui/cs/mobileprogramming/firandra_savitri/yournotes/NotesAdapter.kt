package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView

import id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes.R
import kotlinx.android.synthetic.main.recyclerview_notes.view.*

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteHolder>() {
    private var notes: List<Notes> = ArrayList()

    class NoteHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recyclerview_notes, parent, false)
        return NoteHolder(view)
    }

    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        val currentNote = notes[position]
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
//
//    inner class NoteHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
//    {
//        var textViewTitle: TextView = itemView.findViewById(R.id.name)
//        var textViewDescription: TextView = itemView.findViewById(R.id.notes_content)
//    }
}