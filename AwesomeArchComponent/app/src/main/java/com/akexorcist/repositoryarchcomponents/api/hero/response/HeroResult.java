package com.akexorcist.repositoryarchcomponents.api.hero.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

public class HeroResult {
    private String status;
    private String message;
    @SerializedName("data")
    private List<Hero> heroes;

    public HeroResult() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }
}
