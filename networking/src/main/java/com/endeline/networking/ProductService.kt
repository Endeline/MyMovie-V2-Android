package com.endeline.networking

import com.endeline.datamodels.Product
import retrofit2.http.GET
import retrofit2.http.Path

interface ProductService {

    @GET("${BuildConfig.API_VERSION}/{type}/{category}")
    suspend fun getProducts(@Path("type") type: String, @Path("category") category: String): Product
}