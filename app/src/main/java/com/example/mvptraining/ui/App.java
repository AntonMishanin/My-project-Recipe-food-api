package com.example.mvptraining.ui;

import android.app.Application;

import com.example.mvptraining.di.component.AppComponent;
import com.example.mvptraining.di.component.DaggerAppComponent;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        initAppComponent();
    }

    private void initAppComponent(){
        appComponent = DaggerAppComponent.builder()
                .build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
