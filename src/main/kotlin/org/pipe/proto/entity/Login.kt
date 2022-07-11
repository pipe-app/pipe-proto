package org.pipe.proto.entity

import kotlinx.serialization.Serializable
import org.pipe.proto.UuidSerializer
import java.util.UUID

@Serializable
data class SignUpRequest(
    val login: String,
    val password: String,
    val username: String
)

@Serializable
data class SignInRequest(
    val login: String,
    val password: String
)

@Serializable
data class LoginResponse(
    @Serializable(with = UuidSerializer::class)
    val accessToken: UUID
)