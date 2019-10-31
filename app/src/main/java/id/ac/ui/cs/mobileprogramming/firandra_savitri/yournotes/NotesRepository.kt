package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Application
import androidx.lifecycle.LiveData
import android.os.AsyncTask

class NotesRepository(application: Application) {

    private var noteDao: NotesDao

    private var allNotes: LiveData<List<Notes>>

    private lateinit var detailNote: LiveData<Notes>

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

    fun deleteNote(listId: Int) {
        val deleteNoteAsyncTask = DeleteNotesAsyncTask(noteDao).execute(listId)
    }

    fun detailNote(listId: Int): LiveData<Notes> {
        detailNote = noteDao.detailNote(listId)
        return detailNote;
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

    private class DeleteNotesAsyncTask(val noteDao: NotesDao) : AsyncTask<Int, Unit, Unit>() {

        override fun doInBackground(vararg p0: Int?) {
            noteDao.deleteNote(p0[0]!!)
        }

    }

}