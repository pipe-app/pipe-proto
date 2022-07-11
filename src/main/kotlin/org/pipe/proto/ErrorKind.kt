package org.pipe.proto

import kotlinx.serialization.Serializable

@Serializable
enum class ErrorKind {
    // Common
    INTERNAL_ERROR,
    UNDEFINED_ENDPOINT,
    UNAUTHORIZED,

    // SignIn
    INVALID_USERNAME,
    INVALID_PASSWORD,

    // SignUp
    USERNAME_TAKEN,
    USERNAME_INVALID,
    USERNAME_SHORT,
    USERNAME_LONG,
    PASSWORD_WEAK,

    // User
    USER_NOT_FOUND,
    DISPLAY_NAME_SHORT,
    DISPLAY_NAME_LONG,
}