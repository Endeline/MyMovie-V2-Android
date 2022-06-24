package com.endeline.networking

import com.endeline.datamodels.ProductType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class ProductRepository @Inject constructor() {

    private val service = Retrofit.Builder()
        .baseUrl(BuildConfig.MOVIE_DB_BASE_URL)
        .client(
            OkHttpClient.Builder()
                .readTimeout(TIMEOUT_SECOND, TimeUnit.SECONDS)
                .addInterceptor {
                    var request = it.request()

                    val url = request.url
                        .newBuilder()
                        .addQueryParameter(API_KEY_PARAM, BuildConfig.MOVIE_API_KEY)
                        .build()

                    request = request.newBuilder()
                        .url(url)
                        .build()

                    it.proceed(request)
                }
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = if (BuildConfig.DEBUG) {
                            HttpLoggingInterceptor.Level.BODY
                        } else {
                            HttpLoggingInterceptor.Level.NONE
                        }
                    }
                )
                .build()
        ).addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ProductService::class.java)

    suspend fun getProduct(type: ProductType, category: ProductType) =
        service.getProducts(type.name, category.name)

    companion object {
        private const val API_KEY_PARAM = "api_key"
        private const val TIMEOUT_SECOND = 60L
    }
}