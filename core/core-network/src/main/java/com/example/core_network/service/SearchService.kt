package com.example.core_network.service

import com.example.core_network.Constants.DEFAULT_PAGE
import com.example.core_network.Constants.Fields.LANGUAGE
import com.example.core_network.Constants.Fields.PAGE
import com.example.core_network.Constants.Fields.QUERY
import com.example.core_network.Constants.Path.SEARCH_MOVIE
import com.example.core_network.Constants.Path.SEARCH_TV_SHOW
import com.example.core_network.common.NetworkResponse
import com.example.core_network.model.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {
    @GET(SEARCH_MOVIE)
    suspend fun searchMovie(
        @Query(QUERY) query: String,
        @Query(PAGE) page: Int = DEFAULT_PAGE
    ) : NetworkResponse<List<MovieResponse>>
}