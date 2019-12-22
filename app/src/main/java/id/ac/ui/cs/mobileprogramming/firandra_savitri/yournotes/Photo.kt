package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes


import androidx.room.*

@Entity(tableName = "photos_table")
data class Photo(

    var image: String

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}