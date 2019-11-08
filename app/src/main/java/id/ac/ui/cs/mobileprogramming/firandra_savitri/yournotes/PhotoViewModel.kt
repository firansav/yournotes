package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class PhotoViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: PhotoRepository = PhotoRepository(application)
    private var allPhotos: LiveData<List<Photo>> = repository.getAllPhotos()
    private lateinit var detailPhotos: LiveData<Photo>

    fun insert(note: Photo) {
        repository.insert(note)
    }

    fun getAllPhotos(): LiveData<List<Photo>> {
        return allPhotos
    }

    fun detailPhoto(listId: Int): LiveData<Photo> {
        detailPhotos = repository.detailPhoto(listId)
        return detailPhotos
    }

}