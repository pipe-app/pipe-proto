package org.pipe.proto.entity

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val id: Long,
    val name: String,
    val displayName: String,
    val avatarId: Long?,
    val online: Boolean
)