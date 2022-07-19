package org.pipe.proto

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonObject

@Serializable(with = ResponseSerializer::class)
sealed class Response<out T> {
    data class Success<out T>(val data: T): Response<T>()

    @Serializable
    data class Error(val error: ErrorKind, val message: String?): Response<Nothing>()
}

fun Response<*>.isSuccess(): Boolean {
    return this is Response.Success
}

fun <T> Response<T>.data(): T {
    if (isSuccess()) {
        return (this as Response.Success).data
    }
    throw RuntimeException("Response is not Success to get data")
}

fun Response<*>.error(): Response.Error {
    if (!isSuccess()) {
        return this as Response.Error
    }
    throw RuntimeException("Response is not Error to get error data")
}

class ResponseSerializer<T>(
    private val dataSerializer: KSerializer<T>
) : KSerializer<Response<T>> {

    override val descriptor = dataSerializer.descriptor

    override fun deserialize(decoder: Decoder): Response<T> {
        require(decoder is JsonDecoder)

        val json = decoder.decodeJsonElement()

        return if (json is JsonObject && "error" in json) {
            decoder.json.decodeFromJsonElement(Response.Error.serializer(), json)
        } else {
            Response.Success(decoder.json.decodeFromJsonElement(dataSerializer, json))
        }
    }

    override fun serialize(encoder: Encoder, value: Response<T>) {
        return when(value) {
            is Response.Error -> {
                encoder.encodeSerializableValue(Response.Error.serializer(), value)
            }
            is Response.Success -> {
                encoder.encodeSerializableValue(dataSerializer, value.data)
            }
        }
    }
}