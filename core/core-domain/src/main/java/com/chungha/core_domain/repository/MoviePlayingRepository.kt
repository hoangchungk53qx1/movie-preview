package com.chungha.core_domain.repository

import com.chungha.core_domain.model.MovieModel

interface MoviePlayingRepository {
    suspend fun getPlayingMovie() : List<MovieModel>
}