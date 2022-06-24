package com.endeline.domain.converters

import com.endeline.uimodels.ProductType
import javax.inject.Inject

class ProductTypeConverter @Inject constructor() {

    fun toData(type: ProductType) = when (type) {
        ProductType.Latest -> com.endeline.datamodels.ProductType.Latest
        ProductType.Movie -> com.endeline.datamodels.ProductType.Movie
        ProductType.NowPlaying -> com.endeline.datamodels.ProductType.NowPlaying
        ProductType.Popular -> com.endeline.datamodels.ProductType.Popular
        ProductType.TVAiringToday -> com.endeline.datamodels.ProductType.TVAiringToday
        ProductType.TVOnTheAir -> com.endeline.datamodels.ProductType.TVOnTheAir
        ProductType.TopRated -> com.endeline.datamodels.ProductType.TopRated
        ProductType.Tv -> com.endeline.datamodels.ProductType.Tv
        ProductType.Upcoming -> com.endeline.datamodels.ProductType.Upcoming
        else -> throw RuntimeException("Unsupported type")
    }

    fun toUiModel(type: com.endeline.datamodels.ProductType) = when (type) {
        com.endeline.datamodels.ProductType.Latest -> ProductType.Latest
        com.endeline.datamodels.ProductType.Movie -> ProductType.Movie
        com.endeline.datamodels.ProductType.NowPlaying -> ProductType.NowPlaying
        com.endeline.datamodels.ProductType.Popular -> ProductType.Popular
        com.endeline.datamodels.ProductType.TVAiringToday -> ProductType.TVAiringToday
        com.endeline.datamodels.ProductType.TVOnTheAir -> ProductType.TVOnTheAir
        com.endeline.datamodels.ProductType.TopRated -> ProductType.TopRated
        com.endeline.datamodels.ProductType.Tv -> ProductType.Tv
        com.endeline.datamodels.ProductType.Upcoming -> ProductType.Upcoming
        else -> throw RuntimeException("Unsupported type")
    }
}
