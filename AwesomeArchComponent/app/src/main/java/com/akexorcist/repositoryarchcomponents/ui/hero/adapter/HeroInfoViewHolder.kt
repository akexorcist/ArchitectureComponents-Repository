package com.akexorcist.repositoryarchcomponents.ui.hero.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import com.akexorcist.repositoryarchcomponents.api.config.ENDPOINT
import com.akexorcist.repositoryarchcomponents.api.config.HERO_PHOTO
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.view_hero_info.view.*

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

class HeroInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setName(name: String) = with(itemView) {
        tvHeroName.text = name
    }

    fun setAlias(alias: String) = with(itemView) {
        tvHeroAlias.text = alias
    }

    fun setType(type: String) = with(itemView) {
        tvHeroType.text = type
    }

    fun setImageUrl(url: String) = with(itemView) {
        val requestOptions = RequestOptions()
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
        Glide.with(itemView.context)
                .load(ENDPOINT + HERO_PHOTO + "/" + url)
                .apply(requestOptions)
                .into(ivHeroPhoto)
    }

    fun setCardClickListener(listener: () -> Unit) = with(itemView)  {
        cvHeroInfoContainer.setOnClickListener { listener() }
    }
}
