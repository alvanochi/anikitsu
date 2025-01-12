package com.dicoding.anikitsu.util

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

object Util {
    @RequiresApi(Build.VERSION_CODES.O)
    fun extractYear(inputDate: String): String {
        val instant = Instant.parse(inputDate)

        val formatter = DateTimeFormatter.ofPattern("yyyy")
            .withZone(ZoneId.systemDefault())

        return formatter.format(instant)
    }
}