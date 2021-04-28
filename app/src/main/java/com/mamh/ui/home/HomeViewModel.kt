package com.mamh.ui.home

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mamh.database.local.AccountDatabaseDao
import com.mamh.database.local.AccountInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val application: Application, private val database: AccountDatabaseDao) : ViewModel() {
    companion object {
        private const val TAG = "HomeViewModel成功"
    }

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment111111"
    }
    val text: LiveData<String> = _text

    //TODO 获得所有的账号,
    private val _users = database.getAllAccount()

    //TODO 获得最近一个的账号
    private val _user = MutableLiveData<AccountInfo?>()

    init {
        queryData()
    }

    private fun queryData() {
        viewModelScope.launch {
            _user.value = getAccount()
        }
    }

    private suspend fun getAccount(): AccountInfo? {
        return database.getAccount()
    }

    //将另一个进程的任务卸载这里
    private suspend fun dispatch() {
        withContext(Dispatchers.Default) {

        }
    }
}