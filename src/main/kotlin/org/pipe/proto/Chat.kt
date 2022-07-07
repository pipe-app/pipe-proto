package org.pipe.proto

data class ChatMessage(
    val id: Long,
    val chatId: Long,
    val senderId: Long,
    val replyTo: Long,
    val timestamp: Long,
    val text: String
)

data class Chat(
    val id: Long,
    val partnerId: Long,
    val lastMessage: ChatMessage
)