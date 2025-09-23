package utils

import java.text.SimpleDateFormat
import java.util.Locale

fun String.toDayMonth(): String? {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd.MM", Locale.getDefault())
        val date = inputFormat.parse(this)
        date?.let {
            outputFormat.format(date)
        }
    } catch (e: Exception) {
        null
    }
}
