package org.pipe.proto.entity

import kotlinx.serialization.Serializable

@Serializable
data class ChatMessage(
    val id: Long,
    val chatId: Long,
    val senderId: Long,
    val replyTo: Long?,
    val timestamp: Long,
    val text: String
)

@Serializable
data class Chat(
    val id: Long,
    val partnerId: Long,
    val lastMessage: ChatMessage
)