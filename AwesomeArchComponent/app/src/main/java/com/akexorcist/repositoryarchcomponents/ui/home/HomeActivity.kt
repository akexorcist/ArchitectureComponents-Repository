package com.akexorcist.repositoryarchcomponents.ui.home

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.akexorcist.repositoryarchcomponents.R
import com.akexorcist.repositoryarchcomponents.ui.hero.HeroActivity
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setupView()
    }

    private fun setupView() {
        btnNext?.setOnClickListener { openActivity(HeroActivity::class.java) }
    }

    private fun openActivity(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }
}
