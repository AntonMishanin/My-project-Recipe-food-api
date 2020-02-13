package com.example.mvptraining.ui.main;

import com.example.mvptraining.data.network.RecipeFoodApi;
import com.example.mvptraining.data.network.model.ResponseListRecipes;

public interface MainContract {

    interface Presenter {
        void requestDataFromServer();
    }

    interface MainView {

        void setDataToRecyclerView(ResponseListRecipes responseListRecipes);

        void onResponseFailure(Throwable e);
    }

    interface Interactor {

        interface OnFinishListener {

            void onFinished(ResponseListRecipes responseListRecipes);

            void onFailure(Throwable e);
        }
        void fetchRecipeFood(OnFinishListener onFinishListener, RecipeFoodApi recipeFoodApi);
    }
}
