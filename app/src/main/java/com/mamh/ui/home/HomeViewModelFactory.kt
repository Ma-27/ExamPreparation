package com.mamh.ui.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mamh.database.local.AccountDatabaseDao

class HomeViewModelFactory(
        private val application: Application,
        private val database: AccountDatabaseDao) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(application, database) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}