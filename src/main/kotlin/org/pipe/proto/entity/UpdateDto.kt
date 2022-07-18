package org.pipe.proto.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class UpdateDto {

    @Serializable
    @SerialName("updateUser")
    data class UpdateUser(val user: UserDto): UpdateDto()

    @Serializable
    @SerialName("createChat")
    data class CreateChat(val chat: ChatDto): UpdateDto()

    @Serializable
    @SerialName("deleteChat")
    data class DeleteChat(val chatId: Long): UpdateDto()

    @Serializable
    @SerialName("incomeChatMessage")
    data class IncomeChatMessage(val message: SentMessageDto): UpdateDto()

    @Serializable
    @SerialName("deleteChatMessage")
    data class DeleteChatMessage(
        val chatId: Long,
        val messageId: Long
    ): UpdateDto()
}