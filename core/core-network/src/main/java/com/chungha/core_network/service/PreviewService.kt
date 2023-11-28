package com.chungha.core_network.service

import com.chungha.core_network.Constants
import com.chungha.core_network.model.response.MoviePreviewResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Path

interface PreviewService {

    @GET(Constants.Path.DETAILS_MOVIE)
    suspend fun getPreviewMovieById(
        @Path(Constants.Fields.ID) id: Int,
    ): MoviePreviewResponse

}