package com.mamh.database.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AccountDatabaseDao {
    @Insert()
    fun insert(account: AccountInfo)

    @Update()
    fun update(account: AccountInfo)

    //通过id获取用户信息
    @Query("SELECT * FROM table_account_info WHERE tableId = :id")
    fun getAccountById(id: Int): LiveData<AccountInfo>?

    //通过id删除用户信息
    @Query("DELETE FROM table_account_info WHERE tableId = :id")
    fun deleteAccountById(id: Int)

    //清除全部数据
    @Query("DELETE FROM table_account_info")
    fun deleteAll()

    //获取全部数据
    @Query("SELECT * FROM table_account_info")
    fun getAllAccount(): LiveData<List<AccountInfo>>
}