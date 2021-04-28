package com.mamh.database.local

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_account_info")
data class AccountInfo(
        @PrimaryKey(autoGenerate = true)
        val tableId: Int,

        @Embedded
        val event: Event,

        @ColumnInfo(name = "column_grade")
        val grade: Int
)