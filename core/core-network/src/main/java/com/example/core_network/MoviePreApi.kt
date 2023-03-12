package com.example.core_network

import com.example.core_network.service.MovieService
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import javax.inject.Inject

class MoviePreApi @Inject constructor(private val apiKeyProvider: MoviePreviewKeyProvider) {
//    val movieService : MovieService by lazy {  }
}

internal val MIMETYPE_JSON = "application/json".toMediaType()

@OptIn(ExperimentalSerializationApi::class)
internal val defaultJson = Json {
    ignoreUnknownKeys = true
    explicitNulls = false
}
