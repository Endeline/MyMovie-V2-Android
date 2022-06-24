package com.endeline.data

import com.endeline.datamodels.Product
import com.endeline.datamodels.ProductType
import com.endeline.globalcache.GlobalCache
import com.endeline.networking.ProductRepository
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val globalCache: GlobalCache,
    private val productRepository: ProductRepository
) {

    suspend fun loadProduct(type: ProductType, category: ProductType): Product {
        if (globalCache.isCached(type, category)) {
            globalCache.getFromCache(type, category)
        }

        return productRepository.getProduct(type, category)
    }
}