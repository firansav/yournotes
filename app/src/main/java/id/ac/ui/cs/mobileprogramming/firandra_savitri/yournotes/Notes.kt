package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.media.Image
import androidx.room.*

@Entity(tableName = "notes_table")
data class Notes(

    var image: String,
    var title: String,
    var content: String

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}