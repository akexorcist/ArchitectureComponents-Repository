package com.akexorcist.repositoryarchcomponents.ui.hero

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import android.arch.lifecycle.ViewModel

import com.akexorcist.repositoryarchcomponents.api.Resource
import com.akexorcist.repositoryarchcomponents.api.hero.respond.HeroResult
import com.akexorcist.repositoryarchcomponents.repo.hero.HeroRepository
import com.akexorcist.repositoryarchcomponents.util.AbsentLiveData

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

class HeroViewModel : ViewModel() {
    private val heroRepository: HeroRepository
    val heroesResult: LiveData<Resource<HeroResult>>
    private val forceFetchHero = MutableLiveData<Boolean>()

    init {
        this.heroRepository = HeroRepository.instance
        this.heroesResult = Transformations.switchMap(forceFetchHero, { forceFetch ->
            if (forceFetch == null) {
                AbsentLiveData.create()
            }
            else
                heroRepository.getHero(forceFetch)
        })
    }

    fun getHeroes(forceFetch: Boolean) {
        if (forceFetch) {
            forceFetchHero.value = null
            heroRepository.clearAllHeroesInDatabase()
        }
        if (forceFetchHero.value != null && isShouldBeSkip(forceFetchHero.value!!, forceFetch)) {
            forceFetchHero.value = forceFetch
        }
    }

    private fun isShouldBeSkip(newForceFetch: Boolean, oldForceFetch: Boolean): Boolean {
        return equals(newForceFetch, oldForceFetch) || newForceFetch && !oldForceFetch
    }

    companion object {

        fun equals(a: Any?, b: Any): Boolean {
            return a === b || a != null && a == b
        }
    }
}
