package com.chungha.core_domain.model

data class CastModel(
    val id: Int,
    val name: String,
    val adult: Boolean,
    val castId: Int?,
    val character: String,
    val creditId: String,
    val gender: Int?,
    val knownForDepartment: String,
    val order: Int,
    val originalName: String,
    val popularity: Double,
    val profilePath: String?
)
