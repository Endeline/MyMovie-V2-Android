package com.endeline.mymovie.ui.mymovie.ui.gui.movies.latest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.endeline.domain.repositories.ProductRepository
import com.endeline.uimodels.GlobalState
import com.endeline.uimodels.ProductType
import com.endeline.uimodels.ProductUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productRepository: ProductRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.None)

    val uiState: StateFlow<UiState> get() = _uiState

    fun loadData(type: ProductType, category: ProductType) = viewModelScope.launch {
        productRepository.loadProducts(type, category)
            .catch {
                _uiState.value = UiState.Error
            }
            .collect { state ->
                when (state) {
                    is GlobalState.Error -> _uiState.value = UiState.Error
                    is GlobalState.Loaded -> mapDataToUiState(state.data)
                    GlobalState.Loading -> _uiState.value = UiState.Loading
                }
            }
    }

    private fun mapDataToUiState(data: Any) {
        if (data is ProductUiModel) {
            _uiState.value = UiState.Loaded(data)
        } else {
            _uiState.value = UiState.Error
        }
    }
}

sealed class UiState {
    object None : UiState()
    object Loading : UiState()
    class Loaded(val model: ProductUiModel) : UiState()
    object Error: UiState()
}