package com.example.allinone.di;

import com.example.allinone.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by katakin on 31/07/17.
 */

@Module
public abstract class AndroidBindingModule {
    @ContributesAndroidInjector
    abstract MainActivity mainActivity();
}
