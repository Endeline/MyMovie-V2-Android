package com.endeline.mymovie.ui.mymovie.navigation

sealed class Screens(val route: String, var params: Any? = null) {
    object HomeScreen : Screens("HomeScreen")
    object MovieScreen : Screens("MovieScreen")//, R.string.profile)
    object TvScreen : Screens("TvScreen")//, R.string.friends_list)
    object PeopleScreen : Screens("PeopleScreen")//, R.string.friends_list)


    object TestScreen : Screens("TestScreen")
}