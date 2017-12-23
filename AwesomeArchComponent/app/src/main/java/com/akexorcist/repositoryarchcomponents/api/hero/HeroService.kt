package com.akexorcist.repositoryarchcomponents.api.hero

import android.arch.lifecycle.LiveData
import com.akexorcist.repositoryarchcomponents.api.ApiResponse
import com.akexorcist.repositoryarchcomponents.api.hero.request.VoteBody
import com.akexorcist.repositoryarchcomponents.api.hero.respond.HeroResult
import com.akexorcist.repositoryarchcomponents.api.hero.respond.VoteResult
import retrofit2.http.GET
import retrofit2.http.POST

/**
 * Created by Anirut Teerabut on 12/23/2017.
 */
interface HeroService {
    @GET("/heroes")
    fun heroes(): LiveData<ApiResponse<HeroResult>>

    @POST("/vote")
    fun vote(body: VoteBody): LiveData<ApiResponse<VoteResult>>
}