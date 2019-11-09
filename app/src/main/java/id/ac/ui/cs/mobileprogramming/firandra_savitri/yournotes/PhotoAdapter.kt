package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.recyclerview_photo.view.*

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.PhotoHolder>() {
    private var photos: List<Photo> = ArrayList()

    class PhotoHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoHolder {
        val inflater = LayoutInflater.from(parent.context)
        //@TODO: ubah layout recycler view
        val view = inflater.inflate(R.layout.recyclerview_photo, parent, false)
        return PhotoHolder(view)
    }

    override fun onBindViewHolder(holder: PhotoHolder, position: Int) {
        val currentPhoto = photos[position]
        holder.view.photo_image.setImageURI(Uri.parse(currentPhoto.image))
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun setPhoto(photo: List<Photo>) {
        this.photos = photo
        notifyDataSetChanged()
    }
}