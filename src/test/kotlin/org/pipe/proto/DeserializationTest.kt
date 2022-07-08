package org.pipe.proto

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import org.pipe.proto.entity.Update

class DeserializationTest {

    @Test
    fun testChat() {

    }

    @Test
    fun testUpdate() {
        val json = "{\"type\":\"newChatMessage\",\"message\":{\"id\":7777,\"chatId\":8888,\"senderId\":9999,\"replyTo\":2222,\"timestamp\":784165114,\"text\":\"Test text\"}}"
        val update: Update = Json.decodeFromString(json)

        println(update)
    }

}