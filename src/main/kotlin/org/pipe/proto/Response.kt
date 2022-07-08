package org.pipe.proto

import kotlinx.serialization.Serializable

sealed class Response<T> {
    data class Success<T>(val data: T): Response<T>()

    @Serializable
    data class Error(val type: String, val message: String): Response<Unit>()
}