package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: NotesViewModel
    private val notesAdapter = NotesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NotesViewModel::class.java)

        observeViewModel()
//
//        fab.setOnClickListener{
//            Navigation.findNavController(it)
//                .navigate(ListFragmentDirections.actionCreateList())
//        }

    }


    fun observeViewModel() {
        viewModel.getAllNotes().observe(this,
            Observer<List<Notes>> { t -> notesAdapter.setNotes(t!!) })
    }

}
