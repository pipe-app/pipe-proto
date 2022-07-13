package org.pipe.proto

import kotlinx.serialization.Serializable

@Serializable
enum class ErrorKind {
    // Common
    INTERNAL_ERROR,
    UNDEFINED_ENDPOINT,
    UNAUTHORIZED,
    ACCESS_DENIED,
    INVALID_ARGS,

    // SignIn
    INVALID_LOGIN,
    INVALID_PASSWORD,

    // SignUp
    USERNAME_TAKEN,
    USERNAME_INVALID,
    PASSWORD_WEAK,

    // User
    USER_NOT_FOUND,
    DISPLAY_NAME_SIZE,

    // Chat
    CHAT_NOT_FOUND,
    MESSAGE_NOT_FOUND,
}