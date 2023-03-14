package com.chungha.core_network.di

import com.chungha.core_network.BuildConfig
import com.chungha.core_network.Constants
import com.chungha.core_network.MoviePreAuthInterceptor
import com.chungha.core_network.MoviePreviewKeyProvider
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun retrofit(
        apiKeyProvider: MoviePreviewKeyProvider,
        networkJson: Json = Json { ignoreUnknownKeys = true },
    ): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.API_URL)
        .client(authorizedOkHttpClient(apiKeyProvider))
        .addConverterFactory(
            networkJson.asConverterFactory("application/json".toMediaType())
        )
        .build()

    private fun authorizedOkHttpClient(apiKeyProvider: MoviePreviewKeyProvider): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        // Create the Collector
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        return OkHttpClient().newBuilder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(MoviePreAuthInterceptor(apiKeyProvider))
            .addInterceptor(logging)
            .build()
    }
}