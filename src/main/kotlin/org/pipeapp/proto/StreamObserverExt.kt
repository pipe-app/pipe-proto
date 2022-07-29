package org.pipeapp.proto

import com.google.rpc.Status
import io.grpc.StatusException
import io.grpc.protobuf.StatusProto
import io.grpc.stub.StreamObserver

fun StreamObserver<*>.onError(kind: ErrorKind): StatusException {
    val error = ProtoError.newBuilder()
        .setKind(kind)
        .build()

    val status = Status.newBuilder()
        .setDetails(0, com.google.protobuf.Any.pack(error))
        .build()

    return StatusProto.toStatusException(status)
}