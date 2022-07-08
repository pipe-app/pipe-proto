package org.pipe.proto

import kotlinx.serialization.Serializable

sealed class Response<T> {
    data class Success<T>(val data: T): Response<T>()

    @Serializable
    data class Error(val error: ErrorKind, val message: String?): Response<Unit>()
}

fun Response<*>.isSuccess(): Boolean {
    return this is Response.Success
}

fun <T> Response<T>.data(): T {
    if (isSuccess()) {
        return (this as Response.Success).data
    }
    throw RuntimeException("Response is not Success to get data")
}

fun Response<*>.error(): Response.Error {
    if (!isSuccess()) {
        return this as Response.Error
    }
    throw RuntimeException("Response is not Error to get error data")
}