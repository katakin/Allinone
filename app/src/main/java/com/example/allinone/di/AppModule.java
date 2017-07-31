package com.example.allinone.di;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.allinone.App;
import com.example.allinone.util.RxEventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by katakin on 20/07/17.
 */

@Module(includes = {
        NetworkModule.class,
        AndroidBindingModule.class,
        ViewModelModule.class
})
public class AppModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(App app) {
        return PreferenceManager.getDefaultSharedPreferences(app);
    }

    @Provides
    @Singleton
    RxEventBus provideRxEventBus() {
        return new RxEventBus();
    }
}