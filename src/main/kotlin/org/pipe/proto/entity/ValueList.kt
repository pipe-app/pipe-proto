package org.pipe.proto.entity

@kotlinx.serialization.Serializable
data class ValueList<T>(val values: List<T>)