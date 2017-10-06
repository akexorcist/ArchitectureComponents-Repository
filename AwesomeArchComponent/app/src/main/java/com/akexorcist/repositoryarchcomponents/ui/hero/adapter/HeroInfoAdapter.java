package com.akexorcist.repositoryarchcomponents.ui.hero.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.akexorcist.repositoryarchcomponents.R;
import com.akexorcist.repositoryarchcomponents.api.hero.response.Hero;

import java.util.List;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

public class HeroInfoAdapter extends RecyclerView.Adapter<HeroInfoViewHolder> {
    private List<Hero> heroes;
    private HeroInfoListener heroInfoListener;

    public HeroInfoAdapter() {
    }

    public void setHeroes(List<Hero> heroes) {
        this.heroes = heroes;
    }

    @Override
    public HeroInfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_hero_info, parent, false);
        return new HeroInfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HeroInfoViewHolder holder, int position) {
        Hero hero = heroes.get(position);
        holder.setName(hero.getName());
        holder.setAlias(hero.getAlias());
        holder.setType(hero.getType());
        holder.setImageUrl(hero.getUrl());
        holder.setCardClickListener(view -> onHeroSelected(hero));
    }

    private void onHeroSelected(Hero hero) {
        if (heroInfoListener != null) {
            heroInfoListener.onHeroSelected(hero);
        }
    }

    @Override
    public int getItemCount() {
        return heroes != null ? heroes.size() : 0;
    }

    public void setHeroInfoListener(HeroInfoListener heroInfoListener) {
        this.heroInfoListener = heroInfoListener;
    }

    public interface HeroInfoListener {
        void onHeroSelected(Hero hero);
    }
}
