package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class FactViewModel(application: Application) : AndroidViewModel(application) {

    private var repository: FactRepository = FactRepository(application)
    private var allFacts: LiveData<List<Fact>> = repository.getAllFact()
    private lateinit var detailFacts: LiveData<Fact>

    fun insert(fact: Fact) {
        repository.insert(fact)
    }

    fun getAllFacts(): LiveData<List<Fact>> {
        return allFacts
    }

    fun detailFact(listId: Int): LiveData<Fact> {
        detailFacts = repository.detailFact(listId)
        return detailFacts
    }

}