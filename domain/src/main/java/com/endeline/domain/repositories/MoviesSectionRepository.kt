package com.endeline.domain.repositories

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import com.endeline.uimodels.GlobalState
import com.endeline.uimodels.MoviesScreenUiModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MoviesSectionRepository @Inject constructor() {

    suspend fun loadTabData() = flow {
        emit(GlobalState.Loading)

        delay(2000)

        emit(GlobalState.Loaded(MoviesScreenUiModel(listOf(
            "Latest" to Icons.Filled.Home,
            "NowPlaying" to Icons.Filled.ShoppingCart,
            "Popular" to Icons.Filled.AccountBox,
            "TopRated" to Icons.Filled.Settings,
            "Upcoming" to Icons.Filled.Create,
        ))))

        //Todo check
//        emit(GlobalState.Error<Any>(2))
    }
}