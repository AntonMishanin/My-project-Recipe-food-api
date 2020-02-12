package com.example.mvptraining;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "https://api.edamam.com/";

    private static Retrofit instance;

    public static Retrofit getRetrofitInstance() {
        if (instance == null) {

            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    //.client(okHttpClient)
                    .build();
        }
        return instance;
    }

    public static RecipeFoodApi getRecipeFoodApi(){
        return getRetrofitInstance().create(RecipeFoodApi.class);
    }
}
