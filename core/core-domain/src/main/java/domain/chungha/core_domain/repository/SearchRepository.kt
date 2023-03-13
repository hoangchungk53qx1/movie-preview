package domain.chungha.core_domain.repository

import androidx.paging.PagingData
import com.example.core_network.common.NetworkResponse
import com.example.core_network.model.response.MovieResponse
import domain.chungha.core_domain.model.MovieModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface SearchRepository {
    suspend fun search(query: String): List<MovieModel>
}