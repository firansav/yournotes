package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FactsDao {

    @Insert
    fun insert(fact: Fact)

    @Query("SELECT * FROM fact_table ")
    fun getAllFacts(): LiveData<List<Fact>>

    @Query("SELECT * FROM fact_table WHERE id=:factId")
    fun detailFact(factId: Int): LiveData<Fact>

}