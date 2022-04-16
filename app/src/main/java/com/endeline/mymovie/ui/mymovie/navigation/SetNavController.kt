package com.endeline.mymovie.ui.mymovie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.endeline.mymovie.ui.mymovie.ui.gui.home.HomeScreen
import com.endeline.mymovie.ui.mymovie.ui.gui.home.Params
import com.endeline.mymovie.ui.mymovie.ui.gui.home.TestScreen
import com.endeline.mymovie.ui.mymovie.ui.gui.movies.MoviesScreen
import com.endeline.mymovie.ui.mymovie.ui.gui.people.PeopleScreen
import com.endeline.mymovie.ui.mymovie.ui.gui.tvs.TvScreen

@Composable
fun SetNavController(controller: NavHostController) {
    NavHost(navController = controller, startDestination = Screens.HomeScreen.route) {
        composable(Screens.HomeScreen.route) {
            HomeScreen(controller = controller)
        }

        composable(Screens.MovieScreen.route) {
            MoviesScreen(controller = controller)
        }

        composable(Screens.PeopleScreen.route) {
            PeopleScreen(controller = controller)
        }

        composable(Screens.TvScreen.route) {
            TvScreen(controller = controller)
        }

        composable(Screens.TestScreen.route) {
            TestScreen(controller = controller, params = Screens.TestScreen.params as Params)
        }
    }
}