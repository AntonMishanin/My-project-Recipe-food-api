package com.example.mvptraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private AdapterMainActivity adapterMainActivity;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        fetchRecipeFood();
    }

    private void init() {
        adapterMainActivity = new AdapterMainActivity();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterMainActivity);
    }

    private void fetchRecipeFood() {
        RetrofitClient.getRecipeFoodApi().getRecipes()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<ResponseListRecipes>() {
                    @Override
                    public void onSuccess(ResponseListRecipes responseListRecipes) {
                        List<Hit> hits = responseListRecipes.getmHits();
                        adapterMainActivity.setRecipes(hits);
                        Log.d(TAG, hits.size()+"======");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, e.getMessage());
                    }
                });
    }
}
