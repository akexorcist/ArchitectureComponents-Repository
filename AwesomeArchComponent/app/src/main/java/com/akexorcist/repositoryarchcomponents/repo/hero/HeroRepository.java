package com.akexorcist.repositoryarchcomponents.repo.hero;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Transformations;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.akexorcist.repositoryarchcomponents.api.ApiManager;
import com.akexorcist.repositoryarchcomponents.api.ApiResponse;
import com.akexorcist.repositoryarchcomponents.api.Resource;
import com.akexorcist.repositoryarchcomponents.api.hero.HeroService;
import com.akexorcist.repositoryarchcomponents.api.hero.response.HeroResult;
import com.akexorcist.repositoryarchcomponents.db.DatabaseManager;
import com.akexorcist.repositoryarchcomponents.db.hero.HeroDao;
import com.akexorcist.repositoryarchcomponents.repo.AppExecutors;
import com.akexorcist.repositoryarchcomponents.repo.NetworkBoundResource;

import io.reactivex.Completable;
import io.reactivex.schedulers.Schedulers;

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
        heroService = ApiManager.getHeroService();
        heroDao = DatabaseManager.getHeroDatabase().heroDao();
        appExecutors = AppExecutors.getInstance();
    }

    public LiveData<Resource<HeroResult>> getHero(Boolean isForceFetch) {
        return new NetworkBoundResource<HeroResult, HeroResult>(appExecutors) {
            @Override
            protected void saveCallResult(@NonNull HeroResult result) {
                heroDao.insert(result.getHeroes());
            }

            @Override
            protected boolean shouldFetch(@Nullable HeroResult result) {
                return isForceFetch ||
                        result == null ||
                        result.getHeroes() == null ||
                        result.getHeroes().isEmpty();
            }

            @NonNull
            @Override
            protected LiveData<HeroResult> loadFromDb() {
                return Transformations.map(heroDao.queryAll(), heroes -> {
                    HeroResult result = new HeroResult();
                    result.setHeroes(heroes);
                    result.setStatus("success");
                    result.setMessage("Successful");
                    return result;
                });
            }

            @NonNull
            @Override
            protected LiveData<ApiResponse<HeroResult>> createCall() {
                return heroService.getHeroes();
            }
        }.asLiveData();
    }

    public void clearAllHeroesInDatabase() {
        Completable.complete()
                .observeOn(Schedulers.io())
                .subscribe(() -> heroDao.clearAll());
    }
}
