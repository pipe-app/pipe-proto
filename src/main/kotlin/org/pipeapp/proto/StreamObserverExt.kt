package org.pipeapp.proto

import io.grpc.Status.Code
import io.grpc.protobuf.lite.ProtoLiteUtils
import io.grpc.stub.StreamObserver

val ERROR_KEY: io.grpc.Metadata.Key<ProtoError> = io.grpc.Metadata.Key.of(
    "pipe-error-kind",
    ProtoLiteUtils.metadataMarshaller(ProtoError.getDefaultInstance())
)

fun StreamObserver<*>.onError(kind: ErrorKind, code: Code = Code.CANCELLED) {
    val meta = io.grpc.Metadata()
    meta.put(ERROR_KEY, ProtoError.newBuilder()
        .setKind(kind)
        .build())

    onError(code.toStatus().asException(meta))
}