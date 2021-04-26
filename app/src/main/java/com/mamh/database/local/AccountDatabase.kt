package com.mamh.database.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AccountInfo::class], version = 1, exportSchema = false)
abstract class AccountDatabase : RoomDatabase() {
    abstract val accountDatabaseDao: AccountDatabaseDao

    companion object {
        //volatile变量的值将永远不会被缓存，并且所有读写操作都将在主内存中进行。
        // 这有助于确保的值INSTANCE始终是最新的，并且与所有执行线程相同。
        @Volatile
        private var INSTANCE: AccountDatabase? = null

        //获取database单例，单例模式
        fun getInstance(context: Context): AccountDatabase? {
            var instance = INSTANCE

            synchronized(this) {
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AccountDatabase::class.java,
                        "account_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                //结束函数，防止其他线程直接返回对象
                return instance
            }
        }
    }
}