package com.akexorcist.repositoryarchcomponents.ui.hero

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.MenuItem
import android.widget.Toast
import com.akexorcist.repositoryarchcomponents.R
import com.akexorcist.repositoryarchcomponents.api.Resource
import com.akexorcist.repositoryarchcomponents.api.Status
import com.akexorcist.repositoryarchcomponents.api.hero.respond.Hero
import com.akexorcist.repositoryarchcomponents.api.hero.respond.HeroResult
import com.akexorcist.repositoryarchcomponents.ui.hero.adapter.HeroInfoAdapter
import kotlinx.android.synthetic.main.activity_hero.*

class HeroActivity : AppCompatActivity() {

    private var heroInfoAdapter: HeroInfoAdapter? = null

    private var viewModel: HeroViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero)
        setupView()
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, ViewModelProviders.DefaultFactory(application)).get(HeroViewModel::class.java)
        viewModel?.heroesResult?.observe(this, Observer<Resource<HeroResult>> { onHeroesResult(it) })
        viewModel?.getHeroes(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun setupView() {
        setupActionBar()
        heroInfoAdapter = HeroInfoAdapter()
        heroInfoAdapter?.setHeroInfoListener(onHeroSelected)
        rvHeroes.layoutManager = LinearLayoutManager(this)
        rvHeroes.adapter = heroInfoAdapter
        srHeroes.setOnRefreshListener(onSwipeToRefresh)
    }

    private fun setupActionBar() {
        if (supportActionBar != null) {
            supportActionBar?.setDisplayShowHomeEnabled(true)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun showRefreshing() {
        srHeroes.setRefreshing(true)
    }

    private fun hideRefreshing() {
        srHeroes.setRefreshing(false)
    }

    private fun updateHeroes(heroes: List<Hero>) {
        heroInfoAdapter?.setHeroes(heroes)
        heroInfoAdapter?.notifyDataSetChanged()
    }

    private val onHeroSelected: (hero: Hero) -> Unit = { hero ->
        Toast.makeText(this, hero.name, Toast.LENGTH_SHORT).show()
    }

    private val onSwipeToRefresh: () -> Unit = {
        viewModel?.getHeroes(true)
        hideRefreshing()
    }

    private fun onHeroesResult(resource: Resource<HeroResult>?) {
        if (resource != null) {
            when(resource.status) {
                Status.SUCCESS -> {
                    if (resource.data != null) {
                        updateHeroes(resource.data.heroes)
                    }
                    hideRefreshing()
                }
                Status.ERROR -> {
                    Toast.makeText(this, "Failed to download heroes, please try again", Toast.LENGTH_SHORT).show()
                    hideRefreshing()
                }
                Status.LOADING -> showRefreshing()
            }
        } else {
            Toast.makeText(this, "Resource is null", Toast.LENGTH_SHORT).show()
        }
    }
}
