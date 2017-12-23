package com.akexorcist.repositoryarchcomponents.ui.hero;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;
import android.arch.lifecycle.ViewModel;

import com.akexorcist.repositoryarchcomponents.api.Resource;
import com.akexorcist.repositoryarchcomponents.api.hero.respond.HeroResult;
import com.akexorcist.repositoryarchcomponents.repo.hero.HeroRepository;
import com.akexorcist.repositoryarchcomponents.util.AbsentLiveData;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

public class HeroViewModel extends ViewModel {
    private final HeroRepository heroRepository;
    private LiveData<Resource<HeroResult>> heroResult;
    private final MutableLiveData<Boolean> forceFetchHero = new MutableLiveData<>();

    public HeroViewModel() {
        this.heroRepository = HeroRepository.Companion.getInstance();
        this.heroResult = Transformations.switchMap(forceFetchHero, forceFetch -> {
            if (forceFetch == null) {
                return AbsentLiveData.create();
            }

            return heroRepository.getHero(forceFetch);
        });
    }

    public void getHeroes(boolean forceFetch) {
        if (forceFetch) {
            forceFetchHero.setValue(null);
            heroRepository.clearAllHeroesInDatabase();
        }
        if (forceFetchHero.getValue() != null &&
                isShouldBeSkip(forceFetchHero.getValue(), forceFetch)) {
            forceFetchHero.setValue(forceFetch);
        }
    }

    public LiveData<Resource<HeroResult>> getHeroesResult() {
        return heroResult;
    }

    private boolean isShouldBeSkip(boolean newForceFetch, boolean oldForceFetch) {
        return equals(newForceFetch, oldForceFetch) || (newForceFetch && !oldForceFetch);
    }

    public static boolean equals(Object a, Object b) {
        return (a == b) || (a != null && a.equals(b));
    }
}
