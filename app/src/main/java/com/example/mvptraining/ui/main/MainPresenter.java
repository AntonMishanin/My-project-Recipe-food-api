package com.example.mvptraining.ui.main;

import com.example.mvptraining.data.network.RecipeFoodApi;
import com.example.mvptraining.data.network.model.ResponseListRecipes;

public class MainPresenter implements MainContract.Presenter, MainContract.Interactor.OnFinishListener {

    private MainContract.MainView mainView;
    private MainContract.Interactor interactor;
    private RecipeFoodApi recipeFoodApi;

    public MainPresenter(MainContract.MainView mainView, MainContract.Interactor interactor, RecipeFoodApi recipeFoodApi) {
        this.mainView = mainView;
        this.interactor = interactor;
        this.recipeFoodApi = recipeFoodApi;
    }

    @Override
    public void requestDataFromServer() {
        interactor.fetchRecipeFood(this, recipeFoodApi);
    }

    @Override
    public void onFinished(ResponseListRecipes responseListRecipes) {
        mainView.setDataToRecyclerView(responseListRecipes);
    }

    @Override
    public void onFailure(Throwable e) {
        mainView.onResponseFailure(e);
    }
}
