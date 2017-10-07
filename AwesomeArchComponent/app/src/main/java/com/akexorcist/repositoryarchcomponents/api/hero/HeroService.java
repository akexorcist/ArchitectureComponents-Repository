package com.akexorcist.repositoryarchcomponents.api.hero;

import android.arch.lifecycle.LiveData;

import com.akexorcist.repositoryarchcomponents.api.ApiResponse;
import com.akexorcist.repositoryarchcomponents.api.hero.request.VoteBody;
import com.akexorcist.repositoryarchcomponents.api.hero.response.HeroResult;
import com.akexorcist.repositoryarchcomponents.api.hero.response.VoteResult;

import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

public interface HeroService {
    @GET("/heroes")
    LiveData<ApiResponse<HeroResult>> getHeroes();

    @POST("/vote")
    LiveData<ApiResponse<VoteResult>> vote(VoteBody body);
}
