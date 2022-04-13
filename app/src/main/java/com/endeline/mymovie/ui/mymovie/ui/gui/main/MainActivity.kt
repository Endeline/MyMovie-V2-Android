package com.endeline.mymovie.ui.mymovie

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.endeline.mymovie.ui.mymovie.navigation.SetNavController
import com.endeline.mymovie.ui.mymovie.ui.gui.main.MainViewModel
import com.endeline.mymovie.ui.mymovie.ui.theme.MymovieTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            viewModel.isLoading.value
        }

        setContent {
            MymovieTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    SetNavController(controller = rememberNavController())
                }
            }
        }
    }
}

data class Params(
    val title: String
)

@Composable
fun TestScreen(controller: NavHostController, params: Params) {
    Text(text = "Test ${params.title}!")
}