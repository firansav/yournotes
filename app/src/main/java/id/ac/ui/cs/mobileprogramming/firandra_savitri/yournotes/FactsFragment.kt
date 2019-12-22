package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_facts.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_photos.*
import kotlin.math.roundToInt

class FactsFragment : Fragment() {

    companion object {
        fun newInstance() = FactsFragment()
    }

    init {
        System.loadLibrary("yournotes")
    }

    private lateinit var factViewModel: FactViewModel
    private val adapter = FactAdapter()
    external fun randomizer() : Int

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_facts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragment.notes_rv.visibility = View.GONE

        super.onViewCreated(view, savedInstanceState)

        fact_rv.layoutManager = GridLayoutManager(activity, 1)
        fact_rv.adapter = adapter

        factViewModel = ViewModelProviders.of(this).get(FactViewModel::class.java)

//        val idxFact = randomizer()

        observeViewModel()
    }

    fun observeViewModel() {
        factViewModel.getAllFacts().observe(this,
            Observer<List<Fact>> { t -> adapter.setFact(t!!) })
    }

}