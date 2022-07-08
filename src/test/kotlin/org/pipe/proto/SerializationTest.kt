package org.pipe.proto

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import org.pipe.proto.entity.Chat
import org.pipe.proto.entity.ChatMessage
import org.pipe.proto.entity.Update

class SerializationTest {

    @Test
    fun testChat() {
        val msg = ChatMessage(0,0,0,0, 0, "Test text")
        val chat = Chat(0, 0, msg)
        val msgJson = Json.encodeToString(msg)
        val chatJson = Json.encodeToString(chat)

        println(msgJson)
        println(chatJson)
    }

    @Test
    fun testUpdate() {
        val msg = ChatMessage(7777,8888,9999,2222, 784165114, "Test text")
        val newMessage: Update = Update.NewChatMessage(msg)
        val json = Json.encodeToString(newMessage)

        println(json)
    }

}