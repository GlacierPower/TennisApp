package repository

interface LoggerRepository {

    fun debug(tag: String, message: String)
    fun info(tag: String, message: String)
    fun warning(tag: String, message: String)
    fun error(tag: String, message: String, throwable: Throwable? = null)

    fun logNetworkRequest(url: String, method: String, headers: Map<String, String>, body: String? = null)
    fun logNetworkResponse(url: String, statusCode: Int, headers: Map<String, String> = emptyMap(), body: String? = null, duration: Long = 0)

    fun logNavigation(from: String, to: String, payload: Any? = null)

    fun addSensitiveField(fieldName: String)
}
