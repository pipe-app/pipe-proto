package org.pipe.proto.entity

import kotlinx.serialization.Serializable

@Serializable
data class ChatMessageDto(
    val chatId: Long,
    val replyTo: Long?,
    val text: String
)

@Serializable
data class SentMessageDto(
    val id: Long,
    val senderId: Long,
    val timestamp: Long,
    val message: ChatMessageDto
)

@Serializable
data class CreateChatRequest(
    val partnerId: Long,
    val message: String
)

@Serializable
data class ChatDto(
    val id: Long,
    val firstUser: Long,
    val secondUser: Long,
    val lastMessage: SentMessageDto
)