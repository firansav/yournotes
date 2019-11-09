package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData

class FactRepository(application: Application) {

    private var factDao: FactsDao

    private var allFacts: LiveData<List<Fact>>

    private lateinit var detailFact: LiveData<Fact>

    init {
        val database: FactDatabase = FactDatabase.getInstance(
            application.applicationContext
        )!!
        factDao = database.factDao()
        allFacts = factDao.getAllFacts()
    }

    fun insert(note: Fact) {
        val insertPhotoAsyncTask = InsertPhotoAsyncTask(factDao).execute(note)
    }

    fun getAllFact(): LiveData<List<Fact>> {
        return allFacts
    }

    fun detailFact(listId: Int): LiveData<Fact> {
        detailFact = factDao.detailFact(listId)
        return detailFact;
    }

    private class InsertPhotoAsyncTask(factDao: FactsDao) : AsyncTask<Fact, Unit, Unit>() {
        val factDao = factDao

        override fun doInBackground(vararg p0: Fact?) {
            factDao.insert(p0[0]!!)
        }
    }

}