package com.chungha.core_network.common

import com.chungha.core_network.Constants
import com.chungha.core_network.MoviePreAuthInterceptor
import com.chungha.core_network.MoviePreviewKeyProvider
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@OptIn(ExperimentalSerializationApi::class)
internal fun retrofit(
    apiKeyProvider: MoviePreviewKeyProvider,
    networkJson: Json = Json { ignoreUnknownKeys = true },
): Retrofit = Retrofit.Builder()
    .baseUrl(Constants.API_URL)
    .client(authorizedOkHttpClient(apiKeyProvider))
    .addConverterFactory(
        networkJson.asConverterFactory("application/json".toMediaType())
    )
    .build()

private fun authorizedOkHttpClient(apiKeyProvider: MoviePreviewKeyProvider): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(MoviePreAuthInterceptor(apiKeyProvider))
        .build()
