package com.chungha.movie_preview.di

import com.example.core_network.MoviePreviewKeyProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
//    @Provides
//    @Singleton
//    fun provideMoviePreviewKey(apiKeyProvide : MoviePreviewKeyProvider)
}