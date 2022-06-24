package com.endeline.uimodels

data class ProductUiModel(
    val adult: Boolean?,
    val backdropPath: String?,
    val belongsToCollection: Any?,
    val budget: Int?,
    val genres: List<GenresUiModel>?,
    val homepage: String?,
    val id: Int?,
    val imdbId: String?,
    val originalLanguage: String?,
    val originalTitle: String?,
    val overview: String?,
    val popularity: Int?,
    val posterPath: String?,
    val productionCompanies: List<Any>?,
    val productionCountries: List<Any>?,
    val releaseDate: String?, //"2016-05-10" maybe date
    val revenue: Int?,
    val runtime: Int?,
    val spokenLanguages: List<Any>,
    val status: String?, //"Released" maybe sealed
    val tagline: String?,
    val title: String?,
    val video: Boolean?,
    val voteAverage: Double?,
    val voteCount: Int?
)