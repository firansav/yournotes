package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes;

import android.os.Bundle
import android.util.DisplayMetrics
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*

import kotlinx.android.synthetic.main.fragment_photos.*
import kotlin.math.roundToInt

/**
 * A simple [Fragment] subclass.
 */

class GalleryFragment : Fragment() {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    private lateinit var photoViewModel: PhotoViewModel
    private val adapter = PhotoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fragment.notes_rv.visibility = View.GONE

        super.onViewCreated(view, savedInstanceState)

        val display = activity?.windowManager?.defaultDisplay
        val outMetrics = DisplayMetrics()
        display?.getMetrics(outMetrics)

        val density = resources.displayMetrics.density
        val dpWidth = outMetrics.widthPixels / density
        val columns = (dpWidth / 150).roundToInt()

        photos_rv.layoutManager = GridLayoutManager(activity, columns)
        photos_rv.adapter = adapter

        photoViewModel = ViewModelProviders.of(this).get(PhotoViewModel::class.java)

        observeViewModel()
    }

    fun observeViewModel() {
        photoViewModel.getAllPhotos().observe(this,
            Observer<List<Photo>> { t -> adapter.setPhoto(t!!) })
    }
}