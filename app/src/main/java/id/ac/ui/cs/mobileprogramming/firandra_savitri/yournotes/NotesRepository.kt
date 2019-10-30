package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Application
import android.arch.lifecycle.LiveData
import android.os.AsyncTask

class NotesRepository(application: Application) {

    private var noteDao: NotesDao

    private var allNotes: LiveData<List<Notes>>

    init {
        val database: NotesDatabase = NotesDatabase.getInstance(
            application.applicationContext
        )!!
        noteDao = database.noteDao()
        allNotes = noteDao.getAllNotes()
    }

    fun insert(note: Notes) {
        val insertNoteAsyncTask = InsertNoteAsyncTask(noteDao).execute(note)
    }

    fun deleteAllNotes() {
        val deleteAllNotesAsyncTask = DeleteAllNotesAsyncTask(
            noteDao
        ).execute()
    }

    fun getAllNotes(): LiveData<List<Notes>> {
        return allNotes
    }

    private class InsertNoteAsyncTask(noteDao: NotesDao) : AsyncTask<Notes, Unit, Unit>() {
        val noteDao = noteDao

        override fun doInBackground(vararg p0: Notes?) {
            noteDao.insert(p0[0]!!)
        }
    }


    private class DeleteAllNotesAsyncTask(val noteDao: NotesDao) : AsyncTask<Unit, Unit, Unit>() {

        override fun doInBackground(vararg p0: Unit?) {
            noteDao.deleteAllNotes()
        }
    }

}