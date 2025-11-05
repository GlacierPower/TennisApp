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
        error(e.message.toString())
    }
}

fun String.toDotDate(): String? {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        val outputFormat = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
        val date = inputFormat.parse(this)
        date?.let {
            outputFormat.format(date)
        }
    } catch (e: Exception) {
        error(e.message.toString())
    }
}

fun Int?.toHoursMinutes(): String {
    if (this == null || this <= 0) return ""

    val totalMinutes = this / 60
    val hours = totalMinutes / 60
    val minutes = totalMinutes % 60

    return "$hours:${minutes.toString().padStart(2, '0')}"
}
