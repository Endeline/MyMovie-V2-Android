package com.endeline.mymovie.ui.mymovie.ui.gui.movies.latest

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.endeline.uicomponents.ErrorView
import com.endeline.uicomponents.LoadingView
import com.endeline.uimodels.ProductType

@Composable
fun LatestMovieScreen(
    controller: NavHostController,
    viewModel: ProductViewModel = hiltViewModel()
) {
    val state = viewModel.uiState.collectAsState().value
    when (state) {
        UiState.Error -> {
            ErrorView()
        }
        is UiState.Loaded -> {
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = state.model.originalTitle ?: "dupa")
                Text(text = state.model.overview ?: "dupa2")
                Text(text = state.model.backdropPath ?: "dupa3")
                Text(text = state.model.releaseDate ?: "dupa4")
            }
        }
        UiState.Loading -> LoadingView()
        UiState.None -> {}
    }

    loadDataIfNeeded(state, viewModel)
}

private fun loadDataIfNeeded(state: UiState, viewModel: ProductViewModel) {
    if (state is UiState.None) {
        viewModel.loadData(ProductType.Movie, ProductType.Latest)
    }
}
