package com.example.sos_app.model

import androidx.annotation.DrawableRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "QuickTipsTable")
data class QuickTips(


    @ColumnInfo(name = "content") var content: String,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    var id: Long? = null
)
