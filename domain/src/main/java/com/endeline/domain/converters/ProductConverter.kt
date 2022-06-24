package com.endeline.domain.converters

import com.endeline.datamodels.Product
import com.endeline.uimodels.ProductUiModel
import javax.inject.Inject

class ProductConverter @Inject constructor(
    private val genresConverter: GenresConverter
) {
    fun toUiModel(product: Product) = ProductUiModel(
        adult = product.adult,
        backdropPath = product.backdrop_path,
        belongsToCollection = product.belongs_to_collection,
        budget = product.budget,
        genres = genresConverter.toUiModel(product.genres),
        homepage = product.homepage,
        id = product.id,
        imdbId = product.imdb_id,
        originalLanguage = product.original_language,
        originalTitle = product.original_title,
        overview = product.overview,
        popularity = product.popularity,
        posterPath = product.poster_path,
        productionCompanies = product.production_companies,
        productionCountries = product.production_countries,
        releaseDate = product.release_date,
        revenue = product.revenue,
        runtime = product.runtime,
        spokenLanguages = product.spoken_languages,
        status = product.status,
        tagline = product.tagline,
        title = product.title,
        video = product.video,
        voteAverage = product.vote_average,
        voteCount = product.vote_count
    )
}
