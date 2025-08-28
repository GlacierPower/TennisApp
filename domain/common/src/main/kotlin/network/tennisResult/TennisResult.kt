package network.tennisResult

typealias RootError = DomainError

sealed interface TennisResult<out D, out E : RootError> {

    data class Success<out D, out E : RootError>(val data: D) : TennisResult<D, E>
    data class Error<out D, out E : RootError>(val error: E) : TennisResult<D, E>

    fun getOrNull(): D? {
        return when (this) {
            is Error<D, E> -> null
            is Success<D, E> -> this.data
        }
    }
}