package domain.chungha.core_domain.model

data class MovieModel(
    val id: Int,
    val originalTitle: String,
    val posterPath: String?,
    val voteAverage: Double?,
    val voteCount: Int,
    val runtime: String? = null,
    val overview: String? = null
)
