package com.example.allinone.ui.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.allinone.R;
import com.example.allinone.ui.common.BaseActivity;
import com.example.allinone.databinding.ActivityMainBinding;

import javax.inject.Inject;

/**
 * Created by katakin on 20/07/17.
 */

public class MainActivity extends BaseActivity {

    @Inject ViewModelProvider.Factory viewModelFactory;

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainViewModel viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel.class);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setViewModel(viewModel);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
    }
}
