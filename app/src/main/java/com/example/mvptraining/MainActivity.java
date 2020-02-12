package com.example.mvptraining;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.mvptraining.network.model.Hit;
import com.example.mvptraining.network.model.ResponseListRecipes;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.MainView, OnItemClickListener {

    private AdapterMainActivity adapterMainActivity;
    RecyclerView recyclerView;
    MainContract.Presenter presenter;
    Interactor interactor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        adapterMainActivity = new AdapterMainActivity(this);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapterMainActivity);

        interactor = new Interactor();
        presenter = new MainPresenter(this, interactor);
        presenter.requestDataFromServer();
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
