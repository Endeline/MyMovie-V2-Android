package com.endeline.mymovie.ui.mymovie.navigation

sealed class Screens(val route: String, var params: Any? = null) {
    object HomeScreen : Screens("HomeScreen")

    object TestScreen : Screens("TestScreen")
}