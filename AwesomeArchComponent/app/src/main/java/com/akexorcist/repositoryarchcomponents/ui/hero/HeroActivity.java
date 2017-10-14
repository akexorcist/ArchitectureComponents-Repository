package com.akexorcist.repositoryarchcomponents.ui.hero;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.widget.Toast;

import com.akexorcist.repositoryarchcomponents.R;
import com.akexorcist.repositoryarchcomponents.api.Resource;
import com.akexorcist.repositoryarchcomponents.api.Status;
import com.akexorcist.repositoryarchcomponents.api.hero.response.Hero;
import com.akexorcist.repositoryarchcomponents.api.hero.response.HeroResult;
import com.akexorcist.repositoryarchcomponents.databinding.ActivityHeroBinding;
import com.akexorcist.repositoryarchcomponents.ui.hero.adapter.HeroInfoAdapter;

import java.util.List;

public class HeroActivity extends AppCompatActivity {

    private ActivityHeroBinding mBinding;

    private HeroInfoAdapter heroInfoAdapter;

    private HeroViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_hero);
        setupView();
        initViewModel();
    }

    private void initViewModel() {
        viewModel = ViewModelProviders.of(this, new ViewModelProviders.DefaultFactory(getApplication())).get(HeroViewModel.class);
        viewModel.getHeroesResult().observe(this, this::onHeroesResult);
        viewModel.getHeroes(false);
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

    private void setupView() {
        setupActionBar();
        heroInfoAdapter = new HeroInfoAdapter();
        heroInfoAdapter.setHeroInfoListener(onHeroSelected());
        mBinding.rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        mBinding.rvHeroes.setAdapter(heroInfoAdapter);
        mBinding.srHeroes.setOnRefreshListener(onSwipeToRefresh());
    }

    private void setupActionBar() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void showRefreshing() {
        mBinding.srHeroes.setRefreshing(true);
    }

    private void hideRefreshing() {
        mBinding.srHeroes.setRefreshing(false);
    }

    private void updateHeroes(List<Hero> heroes) {
        heroInfoAdapter.setHeroes(heroes);
        heroInfoAdapter.notifyDataSetChanged();
    }

    private HeroInfoAdapter.HeroInfoListener onHeroSelected() {
        return hero -> {
            // TODO Show vote confirmation dialog
            Toast.makeText(this, hero.getName(), Toast.LENGTH_SHORT).show();
        };
    }

    private SwipeRefreshLayout.OnRefreshListener onSwipeToRefresh() {
        return () -> {
            viewModel.getHeroes(true);
            hideRefreshing();
        };
    }

    private void onHeroesResult(Resource<HeroResult> resource) {
        if (resource != null) {
            if (resource.status == Status.SUCCESS) {
                if (resource.data != null) {
                    updateHeroes(resource.data.getHeroes());
                }
                hideRefreshing();
            } else if (resource.status == Status.ERROR) {
                Toast.makeText(this, "Failed to download heroes, please try again", Toast.LENGTH_SHORT).show();
                hideRefreshing();
            } else if (resource.status == Status.LOADING) {
                showRefreshing();
            }
        } else {
            Toast.makeText(this, "Resource is null", Toast.LENGTH_SHORT).show();
        }
    }
}
