package org.pipe.proto.entity

import kotlinx.serialization.Serializable

@Serializable
data class ChatMessage(
    val chatId: Long,
    val replyTo: Long?,
    val timestamp: Long,
    val text: String
)

@Serializable
data class SentMessage(
    val id: Long,
    val senderId: Long,
    val message: ChatMessage
)

@Serializable
data class CreateChat(
    val partnerId: Long,
    val message: ChatMessage
)

@Serializable
data class Chat(
    val id: Long,
    val partnerId: Long,
    val lastMessage: SentMessage
)