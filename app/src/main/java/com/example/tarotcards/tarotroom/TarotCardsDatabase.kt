package com.example.tarotcards.tarotroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tarotcards.model.TarotCardModel

@Database(entities = [TarotCardModel::class], version = 1)
abstract class TarotCardsDatabase : RoomDatabase() {
    abstract fun tarotCardsDao(): TarotCardsDao

    companion object {
        private var instance: TarotCardsDatabase? = null

        @Synchronized
        fun getInstance(ctx: Context): TarotCardsDatabase {
            if (instance == null)
                instance = Room.databaseBuilder(
                    ctx.applicationContext, TarotCardsDatabase::class.java,
                    "tarot_cards_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(object : RoomDatabase.Callback() {

                    }).build()
            return instance as TarotCardsDatabase
        }

//        private val roomCallback = object : Callback() {F
//            override fun onCreate(db: SupportSQLiteDatabase) {
//                super.onCreate(db)
//                populateDatabase(instance!!)
//            }
//        }
//
//        private fun populateDatabase(db: NoteDatabase) {
//            val noteDao = db.noteDao()
//            subscribeOnBackground {
//                noteDao.insert(Note("title 1", "desc 1", 1))
//                noteDao.insert(Note("title 2", "desc 2", 2))
//                noteDao.insert(Note("title 3", "desc 3", 3))
//
//            }
//        }
    }

}