package com.endeline.uimodels

sealed class ProductType(val name: String) {
    //Global
    object Latest : ProductType("latest")
    object Popular : ProductType("Popular")
    object TopRated : ProductType("top_rated")

    //Movie
    object NowPlaying : ProductType("now_playing")
    object Upcoming : ProductType("upcoming")

    //Tv
    object TVAiringToday : ProductType("airing_today")
    object TVOnTheAir : ProductType("on_the_air")
}
