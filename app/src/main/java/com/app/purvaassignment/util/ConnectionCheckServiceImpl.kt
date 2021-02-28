package com.app.purvaassignment.util

import android.content.Context
import android.net.ConnectivityManager

class ConnectionCheckServiceImpl(val context: Context) {

    fun hasNetworkConnection(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        return netInfo != null && netInfo.isConnectedOrConnecting && cm.activeNetworkInfo.isAvailable && cm.activeNetworkInfo.isConnected
    }
}