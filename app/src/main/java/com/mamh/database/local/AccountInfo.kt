package com.mamh.database.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_account_info")
data class AccountInfo(
    @PrimaryKey(autoGenerate = true)
    val tableId: Int,

    @ColumnInfo(name = "column_event")
    var event: Event,

    @ColumnInfo(name = "column_grade")
    val grade: Int
)