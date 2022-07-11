package org.pipe.proto.entity

import kotlinx.serialization.Serializable
import org.pipe.proto.UuidSerializer
import java.util.UUID

@Serializable
data class LoginRequest(
    val username: String,
    val password: String
)

@Serializable
data class LoginResponse(
    @Serializable(with = UuidSerializer::class)
    val accessToken: UUID
)