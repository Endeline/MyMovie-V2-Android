package com.endeline.mymovie.ui.mymovie.ui.gui.movies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.endeline.domain.MoviesSectionRepository
import com.endeline.uimodels.GlobalState
import com.endeline.uimodels.MoviesScreenUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed class UiState {
    object None : UiState()
    object Loading : UiState()
    class Loaded(val model: MoviesScreenUiModel) : UiState()
    object Error: UiState()
}

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val moviesSectionRepository: MoviesSectionRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.None)

    val uiState: StateFlow<UiState> get() = _uiState

    init {
        loadData()
    }

    private fun loadData() = viewModelScope.launch {
        moviesSectionRepository.loadTabData().collect { state ->
            when(state) {
                is GlobalState.Error -> _uiState.value = UiState.Error
                GlobalState.Loading -> _uiState.value = UiState.Loading
                is GlobalState.Loaded -> {
                    mapDataToUiState(state.data)
                }
            }
        }
    }

    private fun mapDataToUiState(data: Any) {
        if (data is MoviesScreenUiModel) {
            _uiState.value = UiState.Loaded(data)
        } else {
            _uiState.value = UiState.Error
        }
    }
}