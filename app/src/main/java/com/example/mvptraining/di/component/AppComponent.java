package com.example.mvptraining.di.component;

import com.example.mvptraining.di.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

   Retrofit getRetrofit();
}
