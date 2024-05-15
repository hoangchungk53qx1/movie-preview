package com.chungha.core_network.service

import com.chungha.core_network.Constants.DEFAULT_PAGE
import com.chungha.core_network.Constants.Fields.PAGE
import com.chungha.core_network.Constants.Path.NOW_PLAYING_MOVIE
import com.chungha.core_network.Constants.Path.POPULAR_MOVIE
import com.chungha.core_network.Constants.Path.TOP_RATED_MOVIE
import com.chungha.core_network.Constants.Path.UPCOMING_MOVIE
import com.chungha.core_network.common.NetworkResponse
import com.chungha.core_network.model.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET(NOW_PLAYING_MOVIE)
    suspend fun getPlayingMovie(
        @Query(PAGE) page: Int = DEFAULT_PAGE
    ): NetworkResponse<List<MovieResponse>>

    @GET(TOP_RATED_MOVIE)
    suspend fun getTopRatedMovie(
        @Query(PAGE) page: Int = DEFAULT_PAGE
    ): NetworkResponse<List<MovieResponse>>

    @GET(POPULAR_MOVIE)
    suspend fun getPopularMovie(
        @Query(PAGE) page: Int = DEFAULT_PAGE
    ): NetworkResponse<List<MovieResponse>>

    @GET(UPCOMING_MOVIE)
    suspend fun getUpComingMovie(
        @Query(PAGE) page: Int = DEFAULT_PAGE
    ): NetworkResponse<List<MovieResponse>>
}