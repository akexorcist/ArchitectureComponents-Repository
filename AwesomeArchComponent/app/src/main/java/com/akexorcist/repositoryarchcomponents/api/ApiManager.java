package com.akexorcist.repositoryarchcomponents.api;

import com.akexorcist.repositoryarchcomponents.api.hero.HeroService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Akexorcist on 10/4/2017 AD.
 */

public class ApiManager {
    private static HeroService heroService;

    public static HeroService getHeroService() {
        if (heroService == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .addNetworkInterceptor(getDefaultHttpLoggingInterceptor());
            heroService = new Retrofit.Builder()
                    .baseUrl("http://localhost:7777/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                    .client(builder.build())
                    .build()
                    .create(HeroService.class);
        }
        return heroService;
    }

    private static HttpLoggingInterceptor getDefaultHttpLoggingInterceptor() {
        return new HttpLoggingInterceptor(new PrettyHttpLogger()).setLevel(HttpLoggingInterceptor.Level.BODY);
    }
}
