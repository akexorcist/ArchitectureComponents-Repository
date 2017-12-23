package com.akexorcist.repositoryarchcomponents.api

import com.akexorcist.repositoryarchcomponents.api.config.ENDPOINT
import com.akexorcist.repositoryarchcomponents.api.hero.HeroService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


/**
 * Created by Anirut Teerabut on 12/23/2017.
 */
object ApiManager {
    private var heroService: HeroService? = null

    private val defaultHttpLoggingInterceptor: HttpLoggingInterceptor
        get() = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun getHeroService(): HeroService? {
        if (heroService == null) {
            val builder = OkHttpClient.Builder()
                    .addNetworkInterceptor(defaultHttpLoggingInterceptor)

            heroService = Retrofit.Builder()
                    .baseUrl(ENDPOINT)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(LiveDataCallAdapterFactory())
                    .client(builder.build())
                    .build()
                    .create(HeroService::class.java)
        }
        return heroService
    }
}