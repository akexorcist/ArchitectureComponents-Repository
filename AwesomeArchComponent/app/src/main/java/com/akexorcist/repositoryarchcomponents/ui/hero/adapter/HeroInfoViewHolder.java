package com.akexorcist.repositoryarchcomponents.ui.hero.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.akexorcist.repositoryarchcomponents.R;

import static com.akexorcist.repositoryarchcomponents.api.config.UrlKt.ENDPOINT;
import static com.akexorcist.repositoryarchcomponents.api.config.UrlKt.HERO_PHOTO;

/**
 * Created by Akexorcist on 10/6/2017 AD.
 */

public class HeroInfoViewHolder extends RecyclerView.ViewHolder {
    private TextView tvName;
    private TextView tvAlias;
    private TextView tvType;
    private ImageView ivPhoto;
    private CardView cvContainer;

    public HeroInfoViewHolder(View itemView) {
        super(itemView);
        tvName = itemView.findViewById(R.id.tvHeroName);
        tvAlias = itemView.findViewById(R.id.tvHeroAlias);
        tvType = itemView.findViewById(R.id.tvHeroType);
        ivPhoto = itemView.findViewById(R.id.ivHeroPhoto);
        cvContainer = itemView.findViewById(R.id.cvHeroInfoContainer);
    }

    public void setName(String name) {
        tvName.setText(name);
    }

    public void setAlias(String alias) {
        tvAlias.setText(alias);
    }

    public void setType(String type) {
        tvType.setText(type);
    }

    public void setImageUrl(String url) {
        RequestOptions requestOptions = new RequestOptions()
                .circleCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(itemView.getContext())
                .load(ENDPOINT + HERO_PHOTO + "/" + url)
                .apply(requestOptions)
                .into(ivPhoto);
    }

    public void setCardClickListener(View.OnClickListener listener) {
        cvContainer.setOnClickListener(listener);
    }
}
