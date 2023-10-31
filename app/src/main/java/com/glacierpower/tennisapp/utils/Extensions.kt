package com.glacierpower.tennisapp.utils

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import java.text.SimpleDateFormat
import java.util.*

object Extensions {

    fun Fragment.navigate(destination: Int) {
        findNavController().navigate(destination)
    }

    fun String.toDate(
        dateFormat: String = "yyyy-MM-dd HH:mm:ss",
        timeZone: TimeZone = TimeZone.getTimeZone("UTC")
    ): Date {
        val parser = SimpleDateFormat(dateFormat, Locale.getDefault())
        parser.timeZone = timeZone

        return parser.parse(this)
    }

    fun Date.formatTo(
        dateFormat: String,
        timeZone: TimeZone = TimeZone.getTimeZone("UTC")
    ): String {
        val formatter = SimpleDateFormat(dateFormat, Locale.getDefault())
        formatter.timeZone = timeZone
        return formatter.format(this)
    }


    fun Long.shortDate(
        time: Long,
        timeZone: TimeZone = TimeZone.getTimeZone("Europe/Minsk")
    ): String {
        val sdf = SimpleDateFormat("dd.MM.", Locale.getDefault())
        sdf.timeZone = timeZone
        return sdf.format(time * 1000L)
    }

    fun Long.fullDate(
        time: Long,
        timeZone: TimeZone = TimeZone.getTimeZone("Europe/Minsk")
    ): String {
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.getDefault())
        sdf.timeZone = timeZone
        return sdf.format(time * 1000L)
    }




}
