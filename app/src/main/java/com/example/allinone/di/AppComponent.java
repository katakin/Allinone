package com.example.allinone.di;

import com.example.allinone.App;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * Created by katakin on 20/07/17.
 */

@Singleton
@Component(modules = {
        AppModule.class,
        AndroidSupportInjectionModule.class
})
public interface AppComponent extends AndroidInjector<App> {

    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App>{}
}