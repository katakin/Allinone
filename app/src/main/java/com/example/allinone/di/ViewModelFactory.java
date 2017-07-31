package com.example.allinone.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import java.util.Map;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

/**
 * Created by katakin on 28/07/17.
 */

@Singleton
public class ViewModelFactory implements ViewModelProvider.Factory {

    private Map<Class<? extends ViewModel>, Provider<ViewModel>> viewModelMap;

    @Inject
    ViewModelFactory(Map<Class<? extends ViewModel>, Provider<ViewModel>> providedMap) {
        viewModelMap = providedMap;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        // noinspection unchecked
        return (T) viewModelMap.get(modelClass).get();
    }
}
