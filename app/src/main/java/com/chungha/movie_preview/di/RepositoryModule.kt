package com.chungha.movie_preview.di

import com.chungha.core_domain.repository.SearchRepository
import com.example.core_data.repository.SearchMovieRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
interface RepositoryModule {

    @Binds
    @ViewModelScoped
    fun bindMovieRepository(searchMovieRepositoryImpl: SearchMovieRepositoryImpl) : SearchRepository

    @Binds
    @ViewModelScoped
    fun bindMoviePlayingRepository(searchMovieRepositoryImpl: SearchMovieRepositoryImpl) : SearchRepository

}