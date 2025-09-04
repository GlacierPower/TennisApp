package utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

fun String.dateToAge(): String {
    val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.UK)
    val birthDate = sdf.parse(this)

    val birthCalendar = Calendar.getInstance().apply {
        if (birthDate != null) {
            time = birthDate
        }
    }
    val currentCalendar = Calendar.getInstance()
    var age = currentCalendar.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR)
    if (currentCalendar.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
        age--
    }

    return age.toString()
}

fun String.formatDateToDotted(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
    val date: Date = inputFormat.parse(this) ?: return this
    return outputFormat.format(date)
}

fun String.convertToDayMonth(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.getDefault())
    val outputFormat = SimpleDateFormat("dd.MM", Locale.getDefault())

    return try {
        val date: Date = inputFormat.parse(this) ?: return this
        outputFormat.format(date)
    } catch (e: Exception) {
        this
    }
}
