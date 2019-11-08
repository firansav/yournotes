package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PhotoDao {

    @Insert
    fun insert(photo: Photo)

    @Query("SELECT * FROM photos_table ")
    fun getAllPhotos(): LiveData<List<Photo>>

    @Query("SELECT * FROM photos_table WHERE id=:photoId")
    fun detailPhoto(photoId: Int): LiveData<Photo>

}