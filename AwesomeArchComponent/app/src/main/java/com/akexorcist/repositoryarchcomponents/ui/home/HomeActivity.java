package com.akexorcist.repositoryarchcomponents.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.akexorcist.repositoryarchcomponents.R;
import com.akexorcist.repositoryarchcomponents.databinding.ActivityHomeBinding;
import com.akexorcist.repositoryarchcomponents.ui.hero.HeroActivity;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setupView();
    }

    private void setupView() {
        mBinding.btnNext.setOnClickListener(onShowHeroes());
    }

    private View.OnClickListener onShowHeroes() {
        return view -> openActivity(HeroActivity.class);
    }

    private void openActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));
    }
}
