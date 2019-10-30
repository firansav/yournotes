package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import android.os.AsyncTask

@Database(entities = [Notes::class], version = 1)
abstract class NotesDatabase : RoomDatabase() {

    abstract fun noteDao(): NotesDao

    companion object {
        private var instance: NotesDatabase? = null

        fun getInstance(context: Context): NotesDatabase? {
            if (instance == null) {
                synchronized(NotesDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        NotesDatabase::class.java, "notes_database"
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

    class PopulateDbAsyncTask(db: NotesDatabase?) : AsyncTask<Unit, Unit, Unit>() {
        private val noteDao = db?.noteDao()

        override fun doInBackground(vararg p0: Unit?) {
            noteDao?.insert(Notes("Title 1", "description 1"))
            noteDao?.insert(Notes("Title 2", "description 2"))
            noteDao?.insert(Notes("Title 3", "description 3"))
        }
    }

}