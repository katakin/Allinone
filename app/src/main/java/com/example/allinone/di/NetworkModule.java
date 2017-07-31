package com.example.allinone.di;

import com.example.allinone.App;
import com.example.allinone.Constants;
import com.example.allinone.network.Api;
import com.example.allinone.network.CustomTypeAdapterFactory;
import com.example.allinone.network.Methods;
import com.example.allinone.network.CustomInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by katakin on 21/07/17.
 */

@Module
public class NetworkModule {
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(new CustomInterceptor())
                .addNetworkInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .connectTimeout(Constants.CONNECT_TIMEOUT_TIME, TimeUnit.SECONDS)
                .writeTimeout(Constants.CONNECT_TIMEOUT_TIME, TimeUnit.SECONDS)
                .readTimeout(Constants.CONNECT_TIMEOUT_TIME, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(new CustomTypeAdapterFactory())
//                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
//                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
                .create();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, OkHttpClient client) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .client(client)
                .baseUrl(Constants.HOST)
                .build();
    }

    @Provides
    @Singleton
    Api provideApi(Retrofit retrofit) {
        return retrofit.create(Api.class);
    }

    @Provides
    @Singleton
    Methods provideMethods(App app, Api api, Gson gson) {
        return new Methods(app, api, gson);
    }
}
