package com.chungha.core_network.model.response

import com.chungha.core_network.Constants
import com.chungha.core_network.model.response.preview.BelongsToCollection
import com.chungha.core_network.model.response.preview.NetworkGenre
import com.chungha.core_network.model.response.preview.NetworkSpokenLanguage
import com.chungha.core_network.model.response.preview.ProductionCompany
import com.chungha.core_network.model.response.preview.ProductionCountry
import com.chungha.core_network.serializer.LocalDateSerializer
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MoviePreviewResponse(
    @SerialName(Constants.Fields.ID)
    val id: Int,

    @SerialName(Constants.Fields.ADULT)
    val adult: Boolean,

    @SerialName(Constants.Fields.BACKDROP_PATH)
    val backdropPath: String?,

    @SerialName(Constants.Fields.BELONGS_TO_COLLECTION)
    val belongsToCollection: BelongsToCollection?,

    @SerialName(Constants.Fields.BUDGET)
    val budget: Int,

    @SerialName(Constants.Fields.GENRES)
    val genres: List<NetworkGenre>,

    @SerialName(Constants.Fields.HOMEPAGE)
    val homepage: String?,

    @SerialName(Constants.Fields.IMDB_ID)
    val imdbId: String?,

    @SerialName(Constants.Fields.ORIGINAL_LANGUAGE)
    val originalLanguage: String,

    @SerialName(Constants.Fields.ORIGINAL_TITLE)
    val originalTitle: String,

    @SerialName(Constants.Fields.OVERVIEW)
    val overview: String,

    @SerialName(Constants.Fields.POPULARITY)
    val popularity: Double,

    @SerialName(Constants.Fields.POSTER_PATH)
    val posterPath: String?,

    @SerialName(Constants.Fields.PRODUCTION_COMPANIES)
    val productionCompanies: List<ProductionCompany>,

    @SerialName(Constants.Fields.PRODUCTION_COUNTRIES)
    val productionCountries: List<ProductionCountry>,

    @Serializable(LocalDateSerializer::class)
    @SerialName(Constants.Fields.RELEASE_DATE)
    val releaseDate: LocalDate?,

    @SerialName(Constants.Fields.REVENUE)
    val revenue: Long,

    @SerialName(Constants.Fields.RUNTIME)
    val runtime: Int?,

    @SerialName(Constants.Fields.SPOKEN_LANGUAGES)
    val spokenLanguages: List<NetworkSpokenLanguage>,

    @SerialName(Constants.Fields.STATUS)
    val status: String,

    @SerialName(Constants.Fields.TAGLINE)
    val tagline: String?,

    @SerialName(Constants.Fields.TITLE)
    val title: String,

    @SerialName(Constants.Fields.VIDEO)
    val video: Boolean,

    @SerialName(Constants.Fields.VOTE_AVERAGE)
    val voteAverage: Double,

    @SerialName(Constants.Fields.VOTE_COUNT)
    val voteCount: Int,
)
