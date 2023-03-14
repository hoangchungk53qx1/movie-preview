package com.chungha.core_network.common

import com.chungha.core_network.MoviePreviewKeyProvider
import com.chungha.core_network.service.SearchService
import retrofit2.create
import javax.inject.Inject

class ProviderServiceApi @Inject constructor(private val apiKeyProvider: MoviePreviewKeyProvider) {
    val searchService : SearchService by lazy { retrofit(apiKeyProvider = apiKeyProvider).create() }
}