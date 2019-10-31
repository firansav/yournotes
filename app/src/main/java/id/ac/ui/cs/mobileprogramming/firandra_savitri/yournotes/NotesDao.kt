package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import androidx.lifecycle.LiveData
import androidx.room.*;

@Dao
interface NotesDao {

    @Insert
    fun insert(note: Notes)

    @Query("DELETE FROM notes_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM notes_table ")
    fun getAllNotes(): LiveData<List<Notes>>

    @Query( "DELETE FROM notes_table WHERE id=:listId")
    fun deleteNote(listId: Int)

    @Query("SELECT * FROM notes_table WHERE id=:listId")
    fun detailNote(listId: Int): LiveData<Notes>
}