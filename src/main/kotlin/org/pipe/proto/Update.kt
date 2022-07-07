package org.pipe.proto

sealed class Update {
    data class NewChatMessage(val message: ChatMessage): Update()

    data class DeleteChatMessage(
        val chatId: Long,
        val messageId: Long
    ): Update()

    data class UpdateProfile(val profile: Profile): Update()
}