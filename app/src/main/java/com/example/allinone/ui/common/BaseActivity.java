package com.example.allinone.ui.common;

import android.app.Fragment;
import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasFragmentInjector;

/**
 * Created by katakin on 27/07/17.
 */

public class BaseActivity extends AppCompatActivity implements HasFragmentInjector, LifecycleRegistryOwner {

    @Inject DispatchingAndroidInjector<Fragment> fragmentInjector;

    private final LifecycleRegistry registry = new LifecycleRegistry(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public LifecycleRegistry getLifecycle() {
        return registry;
    }

    @Override
    public AndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}
