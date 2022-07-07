package org.pipe.proto

sealed class Response {
    data class Success<T>(val data: T): Response()
    data class Error(val type: String, val message: String): Response()
}