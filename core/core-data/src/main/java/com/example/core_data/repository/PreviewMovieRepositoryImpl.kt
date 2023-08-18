package com.example.core_data.repository

import com.chungha.core_domain.model.MovieDetailModel
import com.chungha.core_domain.repository.PreviewRepository
import com.chungha.core_network.service.PreviewService
import com.example.core_data.mapper.toMovieDetailModel
import javax.inject.Inject

class PreviewMovieRepositoryImpl @Inject constructor(private val previewService: PreviewService) : PreviewRepository {
    override suspend fun getMovieById(id: Int): MovieDetailModel {
        return previewService.getPreviewMovieById(id).toMovieDetailModel()
    }
}