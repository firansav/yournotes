package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: NotesRepository =
        NotesRepository(application)
    private var allNotes: LiveData<List<Notes>> = repository.getAllNotes()
    private lateinit var detailNotes: LiveData<Notes>

    fun insert(note: Notes) {
        repository.insert(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Notes>> {
        return allNotes
    }

    fun detaillNote(listId: Int): LiveData<Notes> {
        detailNotes = repository.detailNote(listId)
        return detailNotes
    }

    fun deleteNote(listId: Int) {
        repository.deleteNote(listId)
    }
}