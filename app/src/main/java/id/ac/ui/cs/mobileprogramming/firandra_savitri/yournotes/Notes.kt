package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "notes_table")
data class Notes(

    var title: String,
    var content: String

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}