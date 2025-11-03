package com.yourpackage.data.common.repository

import repository.LoggerRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoggerRepositoryImpl @Inject constructor() : LoggerRepository {

    private val sensitiveFields = mutableSetOf(
        "password", "token", "authorization", "secret",
        "apikey", "creditcard", "ssn", "cvv", "email"
    )

    override fun debug(tag: String, message: String) {
        logInternal("DEBUG", tag, message)
    }

    override fun info(tag: String, message: String) {
        logInternal("INFO", tag, message)
    }

    override fun warning(tag: String, message: String) {
        logInternal("WARNING", tag, message)
    }

    override fun error(tag: String, message: String, throwable: Throwable?) {
        val fullMessage = if (throwable != null) "$message - ${throwable.message}" else message
        logInternal("ERROR", tag, fullMessage)
    }

    override fun logNetworkRequest(url: String, method: String, headers: Map<String, String>, body: String?) {
        val maskedHeaders = maskHeaders(headers)
        val maskedBody = if ( body != null) maskJson(body) else body

        val message = """
            🌐 REQUEST
            Method: $method
            URL: ${maskUrl(url)}
            Headers: ${maskedHeaders.toLogString()}
            ${if (maskedBody != null) "Body: $maskedBody" else ""}
        """.trimIndent()

        info("NETWORK", message)
    }

    override fun logNetworkResponse(url: String, statusCode: Int, headers: Map<String, String>, body: String?, duration: Long) {
        val maskedBody = if (body != null) maskJson(body) else body
        val message = """
            RESPONSE
            URL: ${maskUrl(url)}
            Status: $statusCode
            Duration: ${duration}ms
            ${if (maskedBody != null) "Body: $maskedBody" else ""}
        """.trimIndent()

        info("NETWORK", message)
    }

    override fun logNavigation(from: String, to: String, payload: Any?) {

        val payloadStr = payload?.let {
            maskJson(it.toString())
        }

        val message = """
            🧭 NAVIGATION
            From: $from
            To: $to
            ${if (payloadStr != null) "Payload: $payloadStr" else ""}
        """.trimIndent()

        info("NAVIGATION", message)
    }

    override fun addSensitiveField(fieldName: String) {
        sensitiveFields.add(fieldName.lowercase())
    }

    private fun logInternal(level: String, tag: String, message: String) {

        println("[$level][$tag] $message")

        logToFirebase(level, tag, message)
    }

    private fun logToFirebase(level: String, tag: String, message: String) {

        // Are we allowed to use FirebaseCrashlytics?
        // FirebaseCrashlytics.log("[$level][$tag] $message")
    }

    private fun maskJson(json: String): String {
        var masked = json
        sensitiveFields.forEach { field ->
            val pattern = """"$field"\s*:\s*"[^"]*"""".toRegex(RegexOption.IGNORE_CASE)
            masked = pattern.replace(masked) { """"$field":"***"""" }

            val patternNonString = """"$field"\s*:\s*[^,}]*""".toRegex(RegexOption.IGNORE_CASE)
            masked = patternNonString.replace(masked) { """"$field":"***"""" }
        }
        return masked
    }

    private fun maskHeaders(headers: Map<String, String>): Map<String, String> {
        return headers.mapValues { (key, value) ->
            if (sensitiveFields.any { key.contains(it, ignoreCase = true) }) "***" else value
        }
    }

    private fun maskUrl(url: String): String {
        return try {
            val urlParts = url.split("?")
            if (urlParts.size == 2) {
                val baseUrl = urlParts[0]
                val queryParams = urlParts[1].split("&").joinToString("&") { param ->
                    val keyValue = param.split("=")
                    if (keyValue.size == 2 && sensitiveFields.any {
                            keyValue[0].contains(it, ignoreCase = true)
                        }) {
                        "${keyValue[0]}=***"
                    } else {
                        param
                    }
                }
                "$baseUrl?$queryParams"
            } else url
        } catch (e: Exception) {
            url
        }
    }

    private fun Map<String, String>.toLogString(): String {
        return if (isEmpty()) "None" else entries.joinToString(", ") { (key, value) -> "$key: $value" }
    }
}
