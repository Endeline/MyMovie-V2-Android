package com.endeline.domain.converters

import com.endeline.datamodels.Genres
import com.endeline.uimodels.GenresUiModel
import javax.inject.Inject

class GenresConverter @Inject constructor() {

    fun toUiModel(genres: List<Genres>?) = genres?.map { genres -> toUiModel(genres) }

    private fun toUiModel(genres: Genres) = GenresUiModel(
        id = genres.id,
        name = genres.name
    )
}
