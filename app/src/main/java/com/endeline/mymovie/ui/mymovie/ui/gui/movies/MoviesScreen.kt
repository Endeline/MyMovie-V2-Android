package com.endeline.mymovie.ui.mymovie.ui.gui.movies

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.endeline.uicomponents.LoadingView
import com.endeline.uimodels.MoviesScreenUiModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@Composable
fun MoviesScreen(controller: NavHostController, viewModel: MovieViewModel = hiltViewModel()) =
    when (viewModel.uiState.collectAsState().value) {
        is UiState.Loaded -> {
            CombinedTab((viewModel.uiState.collectAsState().value as UiState.Loaded).model)
        }
        UiState.Loading -> {
            LoadingView()
        }
        UiState.Error -> {
            //todo ErrorView in uiComponents
        }
        UiState.None -> {}
    }

@OptIn(ExperimentalPagerApi::class)
@Composable
fun CombinedTab(model: MoviesScreenUiModel) {
    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        pageCount = model.tabsList.size,
        initialOffscreenLimit = 2,
        infiniteLoop = true,
        initialPage = 0,
    )

    Column {
        TabRow(selectedTabIndex = pagerState.currentPage) {
            model.tabsList.forEachIndexed { index, pair ->
                Tab(selected = pagerState.currentPage == index, onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                }, text = {
                    Text(text = pair.first, fontSize = 8.sp)
                }, icon = {
                    Icon(imageVector = pair.second, contentDescription = null)
                })
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier.weight(1f)
        ) { index ->
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                when (index) {
                    0 -> LatestMovieScreen()
                    1 -> NowPlayingMovieScreen()
                    2 -> PopularMovieScreen()
                    3 -> TopRatedMovieScreen()
                    4 -> UpcomingMovieScreen()
                }
            }
        }
    }
}

@Composable
fun LatestMovieScreen() {
    Text(text = "Latest Movies Screen")
}

@Composable
fun NowPlayingMovieScreen() {
    Text(text = "Now Playing Movies Screen")
}

@Composable
fun PopularMovieScreen() {
    Text(text = "Popular Movies Screen")
}

@Composable
fun TopRatedMovieScreen() {
    Text(text = "TopRated Movies Screen")
}

@Composable
fun UpcomingMovieScreen() {
    Text(text = "Upcoming Movies Screen")
}