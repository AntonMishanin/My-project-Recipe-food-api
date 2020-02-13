package com.example.mvptraining.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvptraining.ui.App;
import com.example.mvptraining.R;
import com.example.mvptraining.di.component.AppComponent;
import com.example.mvptraining.di.component.DaggerActivityComponent;
import com.example.mvptraining.data.network.RecipeFoodApi;
import com.example.mvptraining.data.network.model.Hit;
import com.example.mvptraining.data.network.model.ResponseListRecipes;
import com.example.mvptraining.di.module.ActivityModule;
import com.example.mvptraining.ui.adapter.AdapterMainActivity;

import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainContract.MainView, OnItemClickListener {

    RecyclerView recyclerView;

    @Inject
    RecipeFoodApi recipeFoodApi;
    @Inject
    AdapterMainActivity adapterMainActivity;
    @Inject
    MainContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDagger();
        init();
    }

    private void init() {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterMainActivity);

        presenter.requestDataFromServer();
    }

    private void initDagger() {
        DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(new ActivityModule(this, this))
                .build()
                .inject(this);
    }

    private AppComponent getAppComponent() {
        return ((App) getApplication()).getAppComponent();
    }

    @Override
    public void setDataToRecyclerView(ResponseListRecipes responseListRecipes) {
        List<Hit> hits = responseListRecipes.getmHits();
        adapterMainActivity.setRecipes(hits);
    }

    @Override
    public void onResponseFailure(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onItemClick(String source) {
        Toast.makeText(this, source, Toast.LENGTH_LONG).show();
    }
}
