package com.akexorcist.repositoryarchcomponents.ui.hero;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.akexorcist.repositoryarchcomponents.R;
import com.akexorcist.repositoryarchcomponents.api.hero.response.Hero;
import com.akexorcist.repositoryarchcomponents.ui.hero.adapter.HeroInfoAdapter;

import java.util.List;

public class HeroActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private HeroInfoAdapter heroInfoAdapter;

    private HeroViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero);
        bindView();
        setupView();
        initViewModel();
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this).get(HeroViewModel.class);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void bindView() {
        rvHeroes = findViewById(R.id.rvHeroes);
    }

    private void setupView() {
        setupActionBar();
        heroInfoAdapter = new HeroInfoAdapter();
        heroInfoAdapter.setHeroInfoListener(onHeroSelected());
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        rvHeroes.setAdapter(heroInfoAdapter);
    }

    private void setupActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void updateHeroes(List<Hero> heroes) {
        heroInfoAdapter.setHeroes(heroes);
        heroInfoAdapter.notifyDataSetChanged();
    }

    private HeroInfoAdapter.HeroInfoListener onHeroSelected() {
        return hero -> {
            // TODO
        };
    }
}
