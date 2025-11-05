package utils

fun String.toStatisticsNumber(): Int {
    val regex = "\\((\\d+)%\\)".toRegex()
    return if (this.contains(regex))
        regex.find(this)?.groupValues?.get(1)?.toInt().orZero()
    else this.toInt().orZero()
}

fun String.toCamelCase(): String =
    this.split('_', ' ')
        .filter { it.isNotEmpty() }
        .joinToString(" ") { it.lowercase().replaceFirstChar { c -> c.titlecase() } }
