package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Application
import androidx.lifecycle.LiveData
import android.os.AsyncTask

class PhotoRepository(application: Application) {

    private var photoDao: PhotoDao

    private var allPhotos: LiveData<List<Photo>>

    private lateinit var detailPhoto: LiveData<Photo>

    init {
        val database: PhotoDatabase = PhotoDatabase.getInstance(
            application.applicationContext
        )!!
        photoDao = database.photoDao()
        allPhotos = photoDao.getAllPhotos()
    }

    fun insert(note: Photo) {
        val inserPhotoAsyncTask = InsertPhotoAsyncTask(photoDao).execute(note)
    }

    fun getAllPhotos(): LiveData<List<Photo>> {
        return allPhotos
    }

    fun detailPhoto(listId: Int): LiveData<Photo> {
        detailPhoto = photoDao.detailPhoto(listId)
        return detailPhoto;
    }

    private class InsertPhotoAsyncTask(photoDao: PhotoDao) : AsyncTask<Photo, Unit, Unit>() {
        val photoDao = photoDao

        override fun doInBackground(vararg p0: Photo?) {
            photoDao.insert(p0[0]!!)
        }
    }

}