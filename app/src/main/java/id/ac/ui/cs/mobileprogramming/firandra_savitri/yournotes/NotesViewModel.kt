package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: NotesRepository =
        NotesRepository(application)
    private var allNotes: LiveData<List<Notes>> = repository.getAllNotes()

    fun insert(note: Notes) {
        repository.insert(note)
    }

    fun deleteAllNotes() {
        repository.deleteAllNotes()
    }

    fun getAllNotes(): LiveData<List<Notes>> {
        return allNotes
    }
}