package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_notes_details.*

/**
 * A simple [Fragment] subclass.
 */
class DetailNote : Fragment() {

    companion object {
        fun newInstance() = DetailNote()
    }

    private lateinit var viewModel: NotesViewModel
    private var noteId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notes_details, container, false)
    }
    
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        arguments?.let {
            noteId = DetailNoteArgs.fromBundle(it).id
        }

        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.detaillNote(noteId+1).observe(this, Observer {
                note -> note?.let{
                notes_title.text = note.title
                notes_content.text = note.content
            }
        })
    }
}
