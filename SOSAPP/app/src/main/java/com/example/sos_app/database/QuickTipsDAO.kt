package com.example.sos_app.database

import com.example.sos_app.model.QuickTips
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuickTipsDAO {

    @Query("SELECT * FROM quicktipstable")
    suspend fun getAllQuickTips(): List<QuickTips>

    @Insert
    suspend fun insertQuickTip(Quicktip: QuickTips)

    @Query("DELETE FROM quicktipstable")
    suspend fun deleteAllQuickTips()


    @Query("SELECT * FROM quicktipstable ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomQuickTip() : List<QuickTips>



}