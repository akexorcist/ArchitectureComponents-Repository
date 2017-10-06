package com.akexorcist.repositoryarchcomponents.repo.hero;

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

    // TODO Let's rock!
}
