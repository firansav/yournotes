package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes;

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager

import kotlinx.android.synthetic.main.fragment_photos.*

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
        super.onViewCreated(view, savedInstanceState)

        photos_rv.layoutManager = GridLayoutManager(activity, 2)
        photos_rv.adapter = adapter

        photoViewModel = ViewModelProviders.of(this).get(PhotoViewModel::class.java)
    }
}