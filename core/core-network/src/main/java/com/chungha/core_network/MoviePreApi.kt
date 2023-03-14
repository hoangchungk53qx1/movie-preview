package com.chungha.core_network

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType


internal val MIMETYPE_JSON = "application/json".toMediaType()

@OptIn(ExperimentalSerializationApi::class)
internal val defaultJson = Json {
    ignoreUnknownKeys = true
    explicitNulls = false
}
