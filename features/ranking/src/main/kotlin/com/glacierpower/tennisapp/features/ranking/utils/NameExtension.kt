package com.glacierpower.tennisapp.features.ranking.utils

fun String.formatName(): String {
    return this
        .split(",")
        .reversed()
        .joinToString(" ")
}
