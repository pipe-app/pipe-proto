package org.pipe.proto.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
sealed class Update {

    @Serializable
    @SerialName("updateProfile")
    data class UpdateProfile(val profile: Profile): Update()

    @Serializable
    @SerialName("newChat")
    data class NewChat(val chat: Chat): Update()

    @Serializable
    @SerialName("deleteChat")
    data class DeleteChat(val chatId: Long): Update()

    @Serializable
    @SerialName("newChatMessage")
    data class NewChatMessage(val message: ChatMessage): Update()

    @Serializable
    @SerialName("deleteChatMessage")
    data class DeleteChatMessage(
        val chatId: Long,
        val messageId: Long
    ): Update()
}