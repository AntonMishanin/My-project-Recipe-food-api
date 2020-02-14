package com.example.mvptraining.ui.main;

import com.example.mvptraining.data.network.RecipeFoodApi;
import com.example.mvptraining.data.network.model.ResponseListRecipes;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class Interactor implements MainContract.Interactor {

    @Override
    public void fetchRecipeFood(final OnFinishListener onFinishListener, RecipeFoodApi recipeFoodApi, String requestFood, String diet) {

        if (diet == null) {
            recipeFoodApi.getRecipes(requestFood)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableSingleObserver<ResponseListRecipes>() {
                        @Override
                        public void onSuccess(ResponseListRecipes responseListRecipes) {
                            onFinishListener.onFinished(responseListRecipes);
                        }

                        @Override
                        public void onError(Throwable e) {
                            onFinishListener.onFailure(e);
                        }
                    });
        }else{
            recipeFoodApi.getRecipesWithDiet(requestFood, diet)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new DisposableSingleObserver<ResponseListRecipes>() {
                        @Override
                        public void onSuccess(ResponseListRecipes responseListRecipes) {
                            onFinishListener.onFinished(responseListRecipes);
                        }

                        @Override
                        public void onError(Throwable e) {
                            onFinishListener.onFailure(e);
                        }
                    });
        }

    }
}
