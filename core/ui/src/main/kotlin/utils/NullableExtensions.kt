package utils

fun Boolean?.orFalse(): Boolean = this ?: false

fun Int?.orZero(): Int = this ?: 0

fun Int?.orEmptyString(): String = this?.toString() ?: ""

fun Double?.orZero(): Double = this ?: 0.0
