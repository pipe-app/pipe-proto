package org.pipeapp.proto

import org.pipeapp.proto.Error.ErrorKind

class ErrorResult(val kind: ErrorKind) : RuntimeException()