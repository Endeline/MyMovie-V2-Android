package com.endeline.mymovie.ui.mymovie.ui.gui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.endeline.mymovie.ui.mymovie.navigation.Screens
import com.endeline.mymovie.ui.mymovie.navigation.SetNavController

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            viewModel.isLoading.value
        }

        val bottomItems = listOf(
            Screens.HomeScreen,
            Screens.MovieScreen,
            Screens.TvScreen,
            Screens.PeopleScreen,
        )

        setContent {
            val navController = rememberNavController()

            Scaffold(
                bottomBar = {
                    BottomNavigation {
                        val navBackStackEntry by navController.currentBackStackEntryAsState()
                        val currentDestination = navBackStackEntry?.destination
                        bottomItems.forEach { screen ->
                            BottomNavigationItem(
                                icon = {
                                    screen.icon?.getIcon()?.let { icon ->
                                        Icon(icon, contentDescription = null)
                                    }
                                },
                                label = {
                                    screen.screenTitle?.let { title ->
                                        Text(title)
                                    }
                                },
                                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                                onClick = {
                                    navController.navigate(screen.route) {
                                        // Pop up to the start destination of the graph to
                                        // avoid building up a large stack of destinations
                                        // on the back stack as users select items
                                        popUpTo(navController.graph.findStartDestination().id) {
                                            saveState = true
                                        }
                                        // Avoid multiple copies of the same destination when
                                        // reselecting the same item
                                        launchSingleTop = true
                                        // Restore state when reselecting a previously selected item
                                        restoreState = true
                                    }
                                }
                            )
                        }
                    }
                }
            ) {
                SetNavController(controller = navController)
            }
        }
    }
}
