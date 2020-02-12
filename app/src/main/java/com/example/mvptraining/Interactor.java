package com.example.mvptraining;

import com.example.mvptraining.network.model.ResponseListRecipes;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class Interactor implements MainContract.Interactor {

    @Override
    public void fetchRecipeFood(final OnFinishListener onFinishListener) {
        RetrofitClient.getRecipeFoodApi().getRecipes()
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
