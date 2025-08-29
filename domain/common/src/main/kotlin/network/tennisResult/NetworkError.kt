package network.tennisResult

interface DataError : DomainError {
    sealed class NetworkError(
        open val errorCodes: List<String>? = null,
        open val detailedMessage: String? = null
    ) : DataError {
        data class BadRequest(
            override val errorCodes: List<String>? = null,
            override val detailedMessage: String? = null
        ) :
            NetworkError(errorCodes, detailedMessage = detailedMessage)

        data class Unauthorized(override val errorCodes: List<String>? = null) :
            NetworkError(errorCodes)

        data class DataNotFound(override val errorCodes: List<String>? = null) :
            NetworkError(errorCodes)

        data class Forbidden(override val errorCodes: List<String>? = null) :
            NetworkError(errorCodes)

        data class IncorrectFormat(override val errorCodes: List<String>? = null) :
            NetworkError(errorCodes)

        data class ServiceUnavailable(override val errorCodes: List<String>? = null) :
            NetworkError(errorCodes)

        data class Conflict(override val errorCodes: List<String>? = null) :
            NetworkError(errorCodes)

        data object Unknown : NetworkError(null)
        data object NoInternetConnection : NetworkError(null)

        fun getLogNetworkError(): String = when (this) {
            is BadRequest -> "BadRequest: codes=$errorCodes"
            is Unauthorized -> "Unauthorized: codes=$errorCodes"
            is DataNotFound -> "DataNotFound: codes=$errorCodes"
            is Forbidden -> "Forbidden: codes=$errorCodes"
            is IncorrectFormat -> "IncorrectFormat: codes=$errorCodes"
            is ServiceUnavailable -> "ServiceUnavailable: codes=$errorCodes"
            is Conflict -> "Conflict: codes=$errorCodes"
            Unknown -> "Unknown network error"
            NoInternetConnection -> "No internet connection"
        }
    }
}