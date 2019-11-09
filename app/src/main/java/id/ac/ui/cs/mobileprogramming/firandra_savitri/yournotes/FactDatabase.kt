package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Fact::class], version = 1)
abstract class FactDatabase : RoomDatabase() {

    abstract fun factDao(): FactsDao

    companion object {
        private var instance: FactDatabase? = null

        fun getInstance(context: Context): FactDatabase? {
            if (instance == null) {
                synchronized(FactDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FactDatabase::class.java, "facts_database"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(roomCallback)
                        .build()
                }
            }
            return instance
        }

        private val roomCallback = object : RoomDatabase.Callback() {
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateDbAsyncTask(instance)
                    .execute()
            }
        }
    }

    class PopulateDbAsyncTask(db: FactDatabase?) : AsyncTask<Unit, Unit, Unit>() {
        private val factDao = db?.factDao()

        override fun doInBackground(vararg p0: Unit?) {
            factDao?.insert(Fact("Superman didn't always fly."))
            factDao?.insert(Fact("Space smells like seared steak."))
            factDao?.insert(Fact("The unicorn is the national animal of Scotland."))
            factDao?.insert(Fact("The total weight of ants on earth once equaled the total weight of people."))
            factDao?.insert(Fact("Pringles aren't actually potato chips."))
            factDao?.insert(Fact("Showers really do spark creativity."))
            factDao?.insert(Fact("Playing the accordion was once required for teachers in North Korea."))
            factDao?.insert(Fact("Children's medicine once contained morphine."))
            factDao?.insert(Fact("Water makes different pouring sounds depending on its temperature."))
            factDao?.insert(Fact("Dogs actually understand some English."))
        }

    }
}