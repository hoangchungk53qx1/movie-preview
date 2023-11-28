package com.example.core_data.repository

import com.chungha.core_domain.model.MovieDetailModel
import com.chungha.core_domain.repository.PreviewRepository
import com.chungha.core_domain.utils.runSuspendCatching
import com.chungha.core_network.di.DispatcherProvider
import com.chungha.core_network.service.PreviewService
import com.example.core_data.mapper.toMovieDetailModel
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PreviewMovieRepositoryImpl @Inject constructor(
    private val previewService: PreviewService,
    private val dispatcherProvider: DispatcherProvider,
) : PreviewRepository {
    override suspend fun getMovieById(id: Int): Result<MovieDetailModel> = runSuspendCatching {
        withContext(dispatcherProvider.io) {
            previewService.getPreviewMovieById(id)
                .toMovieDetailModel()
        }
    }
}