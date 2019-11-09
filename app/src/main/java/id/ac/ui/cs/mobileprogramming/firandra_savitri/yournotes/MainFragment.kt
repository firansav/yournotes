package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager

import id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes.R
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val ADD_NOTE_REQUEST = 1
    private lateinit var noteViewModel: NotesViewModel
    private val adapter = NotesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fab.setOnClickListener { view ->
            startActivityForResult(
                Intent(activity, CreateNoteActivity::class.java),
                ADD_NOTE_REQUEST
            )
        }

        notes_rv.layoutManager = GridLayoutManager(activity, 2)
        notes_rv.adapter = adapter

        noteViewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)
        noteViewModel .getAllNotes().observe(this,
            Observer<List<Notes>> { t -> adapter.setNotes(t!!) })
    }

    fun observeViewModel() {
        noteViewModel.getAllNotes().observe(this,
            Observer<List<Notes>> { t -> adapter.setNotes(t!!) })
    }

}
