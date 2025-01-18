package com.dicoding.anikitsu.util

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

object Util {
    fun extractYear(dateString: String): Int {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())

        val date = format.parse(dateString)

        val calendar = Calendar.getInstance()
        calendar.time = date

        return calendar.get(Calendar.YEAR)
    }
}