package utils

fun String.formatName(): String {
    return this
        .split(",")
        .reversed()
        .joinToString(" ")
}
