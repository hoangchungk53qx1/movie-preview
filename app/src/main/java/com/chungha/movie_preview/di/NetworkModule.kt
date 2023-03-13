package com.chungha.movie_preview.di

import com.chungha.movie_preview.BuildConfig
import com.example.core_network.MoviePreviewKeyProvider
import com.example.core_network.common.ProviderServiceApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideMoviePreviewKey(apiKeyProvide: MoviePreviewKeyProvider) =
        ProviderServiceApi(apiKeyProvide)

    @Provides
    fun provideMovieApiKeyProvider() = object : MoviePreviewKeyProvider {
        override val apiKey: String = BuildConfig.MOVIE_PREVIEW_API_KEY
    }

    @Provides
    fun provideSearchService(apiProvider : ProviderServiceApi) = apiProvider.searchService

}