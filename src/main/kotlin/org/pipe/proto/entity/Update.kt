package org.pipe.proto.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class Update {

    @Serializable
    @SerialName("updateUser")
    data class UpdateUser(val user: User): Update()

    @Serializable
    @SerialName("createChat")
    data class CreateChat(val chat: Chat): Update()

    @Serializable
    @SerialName("deleteChat")
    data class DeleteChat(val chatId: Long): Update()

    @Serializable
    @SerialName("incomeChatMessage")
    data class IncomeChatMessage(val message: SentMessage): Update()

    @Serializable
    @SerialName("deleteChatMessage")
    data class DeleteChatMessage(
        val chatId: Long,
        val messageId: Long
    ): Update()
}