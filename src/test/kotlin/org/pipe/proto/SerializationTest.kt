package org.pipe.proto

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import org.pipe.proto.entity.ChatDto
import org.pipe.proto.entity.ChatMessageDto
import org.pipe.proto.entity.SentMessageDto
import org.pipe.proto.entity.UpdateDto

class SerializationTest {

    @Test
    fun testChat() {
        val msg = SentMessageDto(0, 0, 0, ChatMessageDto(0,0, "Test text"))
        val chat = ChatDto(0, 0, 1, msg)
        val msgJson = Json.encodeToString(msg)
        val chatJson = Json.encodeToString(chat)

        println(msgJson)
        println(chatJson)
    }

    @Test
    fun testUpdate() {
        val msg = SentMessageDto(0, 0, 0, ChatMessageDto(0,0, "Test text"))
        val newMessage: UpdateDto = UpdateDto.IncomeChatMessage(msg)
        val json = Json.encodeToString(newMessage)

        println(json)
    }

}