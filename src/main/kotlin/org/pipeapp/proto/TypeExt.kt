package org.pipeapp.proto

import java.util.UUID

fun Uuid.toJavaUuid(): UUID = UUID(msb, lsb)

fun UUID.toProtobuf() = Uuid.newBuilder()
    .setLsb(leastSignificantBits)
    .setMsb(mostSignificantBits)
    .build()