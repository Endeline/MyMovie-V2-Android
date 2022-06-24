package com.endeline.globalcache

import com.endeline.datamodels.ProductType
import javax.inject.Inject

class GlobalCache @Inject constructor() {

    //todo add checking memory cache, and if offline mode hard cache
    // maybe add timestamp
    fun isCached(type: ProductType, category: ProductType) = false

    //todo add getting data
    fun getFromCache(type: ProductType, category: ProductType) {

    }
}