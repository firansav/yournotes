package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class MyPagerAdapter(fm: FragmentManager, nContext: Context?) : FragmentPagerAdapter(fm){

    val context = nContext

    private val pages = listOf(
        MainFragment(),
        GalleryFragment(),
        EasterEggFragment()
    )

    override fun getItem(position: Int): Fragment {
        return pages[position]
    }

    override fun getCount(): Int {
        return pages.size
    }

    // judul untuk tabs
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> context?.getString(R.string.notes)
            1 -> context?.getString(R.string.gallery)
            else -> context?.getString(R.string.easter_egg)
        }
    }
}