package com.chungha.core_domain.repository

import com.chungha.core_domain.model.MovieModel

interface MoviePlayingRepository {
    suspend fun getPlayingMovie(): List<MovieModel>
    suspend fun getPopularMovie(): List<MovieModel>
    suspend fun getTopRatedMovie(): List<MovieModel>
    suspend fun getUpcomingMovie(): List<MovieModel>
}