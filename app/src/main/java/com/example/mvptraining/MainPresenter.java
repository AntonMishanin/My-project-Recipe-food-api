package com.example.mvptraining;

import com.example.mvptraining.network.model.ResponseListRecipes;

public class MainPresenter implements MainContract.Presenter, MainContract.Interactor.OnFinishListener {

    private MainContract.MainView mainView;
    private MainContract.Interactor interactor;

    public MainPresenter(MainContract.MainView mainView, MainContract.Interactor interactor) {
        this.mainView = mainView;
        this.interactor = interactor;
    }

    @Override
    public void requestDataFromServer() {
        interactor.fetchRecipeFood(this);
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
