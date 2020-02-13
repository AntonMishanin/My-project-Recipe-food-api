package com.example.mvptraining.di.module;

import com.example.mvptraining.di.PerActivity;
import com.example.mvptraining.data.network.RecipeFoodApi;
import com.example.mvptraining.ui.adapter.AdapterMainActivity;
import com.example.mvptraining.ui.main.Interactor;
import com.example.mvptraining.ui.main.MainContract;
import com.example.mvptraining.ui.main.MainPresenter;
import com.example.mvptraining.ui.main.OnItemClickListener;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ActivityModule {

    private MainContract.MainView mainView;
    private OnItemClickListener onItemClickListener;

    public ActivityModule(MainContract.MainView mainView, OnItemClickListener onItemClickListener) {
        this.mainView = mainView;
        this.onItemClickListener = onItemClickListener;
    }

    @PerActivity
    @Provides
    RecipeFoodApi provideRecipeFoodApi(Retrofit retrofit) {
        return retrofit.create(RecipeFoodApi.class);
    }

    @PerActivity
    @Provides
    Interactor provideInteractor() {
        return new Interactor();
    }

    @PerActivity
    @Provides
    MainContract.Presenter providePresenter(Interactor interactor, RecipeFoodApi recipeFoodApi) {
        return new MainPresenter(mainView, interactor, recipeFoodApi);
    }

    @Provides
    AdapterMainActivity provideAdapterMainActivity(){
        return new AdapterMainActivity(onItemClickListener);
    }
}
