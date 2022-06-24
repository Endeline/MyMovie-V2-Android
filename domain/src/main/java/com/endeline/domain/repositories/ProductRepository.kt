package com.endeline.domain.repositories

import com.endeline.data.ProductRepository
import com.endeline.domain.converters.ProductConverter
import com.endeline.domain.converters.ProductTypeConverter
import com.endeline.uimodels.GlobalState
import com.endeline.uimodels.ProductType
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val repository: ProductRepository,
    private val productTypeConverter: ProductTypeConverter,
    private val productConverter: ProductConverter
) {

    fun loadProducts(type: ProductType, category: ProductType) = flow {

        emit(GlobalState.Loading)

        coroutineScope {
            val response = async {
                repository.loadProduct(
                    productTypeConverter.toData(type),
                    productTypeConverter.toData(category)
                )
            }

            val xxx = response.await()

            emit(GlobalState.Loaded(productConverter.toUiModel(xxx)))
        }
    }
}
