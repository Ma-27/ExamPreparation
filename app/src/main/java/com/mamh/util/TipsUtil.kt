package com.mamh.util

import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class TipsUtil {
    fun View.showSnackBar(snackBarText: String, timeLength: Int) {
        Snackbar.make(this, snackBarText, timeLength).run {
            show()
        }
    }

    fun View.showToast(toastText: String, timeLength: Int) {
        Toast.makeText(context, toastText, timeLength).show()
    }
}