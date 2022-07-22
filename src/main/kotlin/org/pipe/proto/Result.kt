package org.pipe.proto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject

@Serializable(with = ResultSerializer::class)
sealed class Result<out T> {
    data class Ok<out T>(val data: T): Result<T>()

    @Serializable
    data class Error(val error: ErrorKind, val message: String?): Result<Nothing>()
}

class ResultSerializer<T>(
    private val dataSerializer: KSerializer<T>
) : KSerializer<Result<T>> {

    override val descriptor = dataSerializer.descriptor

    override fun deserialize(decoder: Decoder): Result<T> {
        require(decoder is JsonDecoder)

        val json = decoder.decodeJsonElement()

        return if (json is JsonObject && "error" in json) {
            decoder.json.decodeFromJsonElement(Result.Error.serializer(), json)
        } else {
            Result.Ok(decoder.json.decodeFromJsonElement(dataSerializer, json))
        }
    }

    override fun serialize(encoder: Encoder, value: Result<T>) {
        return when(value) {
            is Result.Error ->
                encoder.encodeSerializableValue(Result.Error.serializer(), value)
            is Result.Ok ->
                encoder.encodeSerializableValue(dataSerializer, value.data)
        }
    }
}