package com.chungha.core_network.model.response

import com.chungha.core_network.Constants
import kotlinx.datetime.LocalDate
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieResponse(
    @SerialName(Constants.Fields.ID)
    val id: Int,

    @SerialName(Constants.Fields.TITLE)
    val title: String,

    @SerialName(Constants.Fields.OVERVIEW)
    val overview: String,

    @SerialName(Constants.Fields.POPULARITY)
    val popularity: Double,

    @SerialName(Constants.Fields.ADULT)
    val adult: Boolean,

    @SerialName(Constants.Fields.GENRE_IDS)
    val genreIds: List<Int>,

    @SerialName(Constants.Fields.ORIGINAL_TITLE)
    val originalTitle: String,

    @SerialName(Constants.Fields.ORIGINAL_LANGUAGE)
    val originalLanguage: String,

    @SerialName(Constants.Fields.VOTE_AVERAGE)
    val voteAverage: Double,

    @SerialName(Constants.Fields.VOTE_COUNT)
    val voteCount: Int,

    @SerialName(Constants.Fields.POSTER_PATH)
    val posterPath: String?,

    @SerialName(Constants.Fields.BACKDROP_PATH)
    val backdropPath: String?,

    @SerialName(Constants.Fields.VIDEO)
    val video: Boolean
)
