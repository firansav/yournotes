package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import androidx.room.*

@Entity(tableName = "fact_table")
data class Fact(

    var fact: String

) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

}