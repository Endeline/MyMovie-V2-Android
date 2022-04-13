package com.endeline.mymovie.ui.mymovie.ui.gui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.endeline.mymovie.ui.mymovie.ui.gui.main.Params
import com.endeline.mymovie.ui.mymovie.navigation.Screens

var counter = 0

@Composable
fun HomeScreen(controller: NavHostController) {
    Column {
        Text(text = "Hello HOME SCREEN")
        Button(onClick = { controller.navigate(Screens.TestScreen.apply {
            this.params = Params("test screen ${counter++}")
        }.route) }) {
            Text(text = "test navigate")
        }
    }

}