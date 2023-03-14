package com.chungha.core_network.common

import com.chungha.core_network.BuildConfig
import com.chungha.core_network.Constants
import com.chungha.core_network.MoviePreAuthInterceptor
import com.chungha.core_network.MoviePreviewKeyProvider
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Provides
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

//@OptIn(ExperimentalSerializationApi::class)
//



