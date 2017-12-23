package com.akexorcist.repositoryarchcomponents.ui.hero.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.akexorcist.repositoryarchcomponents.R
import com.akexorcist.repositoryarchcomponents.api.hero.respond.Hero

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

class HeroInfoAdapter : RecyclerView.Adapter<HeroInfoViewHolder>() {
    private var heroes: List<Hero>? = null
    private var heroInfoListener: ((hero: Hero) -> Unit)? = null

    fun setHeroes(heroes: List<Hero>) {
        this.heroes = heroes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroInfoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_hero_info, parent, false)
        return HeroInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroInfoViewHolder, position: Int) {
        val hero = heroes!![position]
        holder.setName(hero.name)
        holder.setAlias(hero.alias)
        holder.setType(hero.type)
        holder.setImageUrl(hero.url)
        holder.setCardClickListener { onHeroSelected(hero) }
    }

    private fun onHeroSelected(hero: Hero) {
        heroInfoListener?.invoke(hero)
    }

    override fun getItemCount(): Int {
        return heroes?.size ?: 0
    }

    fun setHeroInfoListener(heroInfoListener: (hero: Hero) -> Unit) {
        this.heroInfoListener = heroInfoListener
    }

}
