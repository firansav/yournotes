package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.youtube.player.YouTubeStandalonePlayer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_weather.*

class EasterEggFragment : Fragment() {

    companion object {
        fun newInstance() = GalleryFragment()
    }

    var apiKey = "AIzaSyBV3yUW7kLq4Zd8eGaoujSUEP9JbtUdBk0"
    var id = "ap14O5-G7UA"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fragment.notes_rv.visibility = View.GONE

//        var str = sendGetRequest()
//        weather_temp.text = str

        button_play.setOnClickListener {
            val intent = YouTubeStandalonePlayer.createVideoIntent(activity, apiKey, id)
            startActivity(intent)
        }

        button_play_music.setOnClickListener {
            Toast.makeText(activity, "Music Played", Toast.LENGTH_SHORT).show()
            activity?.startService(Intent(activity, MusicService::class.java))
        }

        button_stop_music.setOnClickListener {
            Toast.makeText(activity, "Music Stopped", Toast.LENGTH_SHORT).show()
            activity?.stopService(Intent(activity, MusicService::class.java))
        }
    }
}