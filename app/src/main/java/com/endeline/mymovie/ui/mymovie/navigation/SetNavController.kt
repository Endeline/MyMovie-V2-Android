package com.endeline.mymovie.ui.mymovie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.endeline.mymovie.ui.mymovie.ui.gui.main.Params
import com.endeline.mymovie.ui.mymovie.ui.gui.main.TestScreen
import com.endeline.mymovie.ui.mymovie.ui.gui.home_screen.HomeScreen

@Composable
fun SetNavController(controller: NavHostController) {
    NavHost(navController = controller, startDestination = Screens.HomeScreen.route) {
        composable(Screens.HomeScreen.route) {
            HomeScreen(controller = controller)
        }

        composable(Screens.TestScreen.route) {
            TestScreen(controller = controller, params = Screens.TestScreen.params as Params)
        }
    }
}