package com.example.mvptraining.data.network;

import com.example.mvptraining.data.network.model.ResponseListRecipes;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RecipeFoodApi {

    @GET("/search?")
    Single<ResponseListRecipes> getRecipes(@Query("q") String requestFood);

    @GET("/search?")
    Single<ResponseListRecipes> getRecipesWithDiet(@Query("q") String requestFood, @Query("diet") String nameDiet);
}
