package com.glacierpower.tennisapp.utils

import java.net.ConnectException
import java.net.UnknownHostException

object NetworkUtils {

    suspend fun <T> executeNonBlocking(
        execute: suspend () -> ResultState<T>
    ): ResultState<T> {
        return try {
            execute()
        } catch (e: UnknownHostException) {
            Error<T>(e)
        } catch (e: ConnectException) {
            Error<T>(e)
        }
    }
}