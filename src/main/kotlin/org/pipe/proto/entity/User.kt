package org.pipe.proto.entity

import kotlinx.serialization.Serializable

@Serializable
data class User(
    val id: Long,
    val name: String,
    val displayName: String?,
    val avatarId: Long?,
    val online: Boolean
)