package com.akexorcist.repositoryarchcomponents.repo.hero;

import android.arch.lifecycle.LiveData;

import com.akexorcist.repositoryarchcomponents.api.Resource;
import com.akexorcist.repositoryarchcomponents.api.hero.HeroService;
import com.akexorcist.repositoryarchcomponents.api.hero.response.HeroResult;
import com.akexorcist.repositoryarchcomponents.db.hero.HeroDao;
import com.akexorcist.repositoryarchcomponents.repo.AppExecutors;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

public class HeroRepository {
    private static HeroRepository heroRepository;

    public static HeroRepository getInstance() {
        if (heroRepository == null) {
            heroRepository = new HeroRepository();
        }
        return heroRepository;
    }

    private HeroService heroService;
    private HeroDao heroDao;
    private AppExecutors appExecutors;

    private HeroRepository() {
        heroService = null;
        heroDao = null;
        appExecutors = null;
    }

    public LiveData<Resource<HeroResult>> getHero(Boolean isForceFetch) {
        return null;
    }

    public void clearAllHeroesInDatabase() {

    }
}
