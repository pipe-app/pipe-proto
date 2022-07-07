package org.pipe.proto

data class Profile(
    val id: Long,
    val name: String,
    val displayName: String,
    val avatarId: Long,
    val online: Boolean
)