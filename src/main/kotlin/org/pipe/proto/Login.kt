package org.pipe.proto

import java.util.UUID

data class LoginRequest(
    val signIn: Boolean,
    val username: String,
    val password: String
)

data class LoginResponse(
    val accessToken: UUID
)