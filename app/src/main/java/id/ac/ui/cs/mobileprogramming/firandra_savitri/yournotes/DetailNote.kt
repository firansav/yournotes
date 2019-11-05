package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

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
}
