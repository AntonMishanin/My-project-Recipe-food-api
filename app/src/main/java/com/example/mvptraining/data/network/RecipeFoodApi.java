package com.example.mvptraining.data.network;

import com.example.mvptraining.data.network.model.ResponseListRecipes;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface RecipeFoodApi {

    @GET("/search?q=meat&app_id=5b00cdae&app_key=3647593669f1be0e15a1c8c7c7c40264")
    Single<ResponseListRecipes> getRecipes();
}