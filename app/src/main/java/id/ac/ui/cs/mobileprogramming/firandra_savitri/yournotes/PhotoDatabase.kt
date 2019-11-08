package id.ac.ui.cs.mobileprogramming.firandra_savitri.yournotes

import androidx.room.*
import android.content.Context
import android.os.AsyncTask
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = [Photo::class], version = 1)
abstract class PhotoDatabase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao

    companion object {
        private var instance: PhotoDatabase? = null

        fun getInstance(context: Context): PhotoDatabase? {
            if (instance == null) {
                synchronized(PhotoDatabase::class) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PhotoDatabase::class.java, "photos_database"
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

    class PopulateDbAsyncTask(db: PhotoDatabase?) : AsyncTask<Unit, Unit, Unit>() {
        private val photoDao = db?.photoDao()

        override fun doInBackground(vararg p0: Unit?) {
//            noteDao?.insert(Notes("Title 1", "Isi 1"))
//            noteDao?.insert(Notes("Title 2", "Isi 2"))
//            noteDao?.insert(Notes("Title 3", "Isi 3"))
        }
    }

}