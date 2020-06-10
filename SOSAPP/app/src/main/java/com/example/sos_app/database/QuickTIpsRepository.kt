package com.example.sos_app.database

import android.content.Context
import com.example.sos_app.model.QuickTips

class QuickTIpsRepository(context: Context) {


    private val quicktipsDao: QuickTipsDAO


    init {
        val database = QuickTipsDatabase.getDatabase(context)
        quicktipsDao = database!!.quickTipsDao()
    }

    suspend fun getAllGames(): List<QuickTips> = quicktipsDao.getAllQuickTips()

    suspend fun insertQuickTip(quicktips: QuickTips) = quicktipsDao.insertQuickTip(quicktips)

    suspend fun deleteAllRandomTip() = quicktipsDao.deleteAllQuickTips()

    suspend fun getRandomTip() = quicktipsDao.getRandomQuickTip()


}