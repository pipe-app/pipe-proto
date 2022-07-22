package org.pipe.proto

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Test
import org.pipe.proto.entity.LoginResponse
import java.util.*

class ResultTest {

    @Test
    fun testDecoding() {
        val success = "{\"userId\":777,\"accessToken\":\"d91e20c5-c726-46a4-a26d-dcb587deb051\"}"
        val error = "{\"error\":\"INTERNAL_ERROR\",\"message\":null}"

        println(Json.decodeFromString<Result<LoginResponse>>(success))
        println(Json.decodeFromString<Result<LoginResponse>>(error))
    }

    @Test
    fun testEncoding() {
        val data = LoginResponse(777, UUID.randomUUID())
        val resp: Result<LoginResponse> = Result.Ok(data)
        val error: Result<LoginResponse> = Result.Error(ErrorKind.INTERNAL_ERROR, null)

        println(Json.encodeToString(resp))
        println(Json.encodeToString(error))
    }

}