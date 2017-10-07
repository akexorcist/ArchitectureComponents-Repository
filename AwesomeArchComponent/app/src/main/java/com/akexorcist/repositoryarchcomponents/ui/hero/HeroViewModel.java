package com.akexorcist.repositoryarchcomponents.ui.hero;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.akexorcist.repositoryarchcomponents.api.Resource;
import com.akexorcist.repositoryarchcomponents.api.hero.response.HeroResult;
import com.akexorcist.repositoryarchcomponents.repo.hero.HeroRepository;

import java.util.Objects;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

public class HeroViewModel extends ViewModel {
    private final HeroRepository heroRepository;
    private LiveData<Resource<HeroResult>> heroResult;
    private final MutableLiveData<Boolean> forceFetchHero;

    public HeroViewModel() {
        heroRepository = null;
        forceFetchHero = null;
    }

    public void getHeroes(boolean forceFetch) {

    }

    public LiveData<Resource<HeroResult>> getHeroesResult() {
        return null;
    }

    private boolean isShouldBeSkip(boolean newForceFetch, boolean oldForceFetch) {
        return Objects.equals(newForceFetch, oldForceFetch) || (newForceFetch && !oldForceFetch);
    }
}
