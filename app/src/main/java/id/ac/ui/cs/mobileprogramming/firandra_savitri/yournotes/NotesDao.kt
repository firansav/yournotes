package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*

@Dao
interface NotesDao {

    @Insert
    fun insert(note: Notes)

    @Query("DELETE FROM notes_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM notes_table ")
    fun getAllNotes(): LiveData<List<Notes>>

}