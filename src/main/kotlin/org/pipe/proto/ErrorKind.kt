package org.pipe.proto

import kotlinx.serialization.Serializable

@Serializable
enum class ErrorKind {
    // Common
    INTERNAL_ERROR,
    UNDEFINED_ENDPOINT,
    UNAUTHORIZED,

    // SignIn
    INVALID_LOGIN,
    INVALID_PASSWORD,

    // SignUp
    USERNAME_TAKEN,
    LOGIN_INVALID,
    USERNAME_INVALID,
    PASSWORD_WEAK,

    // User
    USER_NOT_FOUND,
    DISPLAY_NAME_SIZE,
}