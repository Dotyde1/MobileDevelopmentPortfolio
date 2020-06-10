package com.example.sos_app.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sos_app.model.QuickTips

@Database(entities = arrayOf(QuickTips::class), version = 1)
abstract class QuickTipsDatabase : RoomDatabase() {
    abstract fun quickTipsDao(): QuickTipsDAO

    companion object {
        private const val DATABASE_NAME = "GAME_DATABASE"

        @Volatile
        private var QuickTipsDatabaseInstance: QuickTipsDatabase? = null

        fun getDatabase(context: Context): QuickTipsDatabase? {
            if (QuickTipsDatabaseInstance == null) {
                synchronized(QuickTipsDatabase::class.java) {
                    if (QuickTipsDatabaseInstance == null) {
                        QuickTipsDatabaseInstance =
                            Room.databaseBuilder(context.applicationContext, QuickTipsDatabase::class.java, DATABASE_NAME).build()
                    }
                }
            }
            return QuickTipsDatabaseInstance
        }
    }
}