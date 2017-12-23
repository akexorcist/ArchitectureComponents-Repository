package com.akexorcist.repositoryarchcomponents.repo.hero

import android.arch.lifecycle.LiveData

import com.akexorcist.repositoryarchcomponents.api.Resource
import com.akexorcist.repositoryarchcomponents.api.hero.HeroService
import com.akexorcist.repositoryarchcomponents.api.hero.respond.HeroResult
import com.akexorcist.repositoryarchcomponents.hero.HeroDao
import com.akexorcist.repositoryarchcomponents.repo.AppExecutors

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

class HeroRepository private constructor() {

    private val heroService: HeroService?
    private val heroDao: HeroDao?
    private val appExecutors: AppExecutors?

    init {
        heroService = null
        heroDao = null
        appExecutors = null
    }

    fun getHero(isForceFetch: Boolean?): LiveData<Resource<HeroResult>>? {
        return null
    }

    fun clearAllHeroesInDatabase() {

    }

    companion object {
        private var heroRepository: HeroRepository? = null

        val instance: HeroRepository
            get() {
                if (heroRepository == null) {
                    heroRepository = HeroRepository()
                }
                return heroRepository as HeroRepository
            }
    }
}
