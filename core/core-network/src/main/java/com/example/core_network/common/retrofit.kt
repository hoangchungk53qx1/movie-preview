package com.example.core_network.common

import com.example.core_network.*
import com.example.core_network.MIMETYPE_JSON
import com.example.core_network.defaultJson
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import retrofit2.Retrofit

@OptIn(ExperimentalSerializationApi::class)
internal fun retrofit(
    apiKeyProvider: MoviePreviewKeyProvider,
    json: Json = defaultJson
): Retrofit = Retrofit.Builder()
    .baseUrl(Constants.API_URL)
    .client(authorizedOkHttpClient(apiKeyProvider))
    .addConverterFactory(json.asConverterFactory(MIMETYPE_JSON))
    .build()

private fun authorizedOkHttpClient(apiKeyProvider: MoviePreviewKeyProvider): OkHttpClient =
    OkHttpClient.Builder()
        .addInterceptor(MoviePreAuthInterceptor(apiKeyProvider))
        .build()
