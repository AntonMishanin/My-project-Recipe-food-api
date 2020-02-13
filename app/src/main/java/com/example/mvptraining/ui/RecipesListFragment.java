package com.example.mvptraining.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvptraining.R;
import com.example.mvptraining.data.network.RecipeFoodApi;
import com.example.mvptraining.data.network.model.Hit;
import com.example.mvptraining.data.network.model.ResponseListRecipes;
import com.example.mvptraining.di.component.AppComponent;
import com.example.mvptraining.di.component.DaggerActivityComponent;
import com.example.mvptraining.di.module.ActivityModule;
import com.example.mvptraining.ui.adapter.AdapterMainActivity;
import com.example.mvptraining.ui.main.MainContract;
import com.example.mvptraining.ui.main.OnItemClickListener;

import java.util.List;

import javax.inject.Inject;

public class RecipesListFragment extends Fragment implements OnItemClickListener, MainContract.MainView {

    @Inject
    RecipeFoodApi recipeFoodApi;
    @Inject
    AdapterMainActivity adapterMainActivity;
    @Inject
    MainContract.Presenter presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipes_list, container, false);

        initDagger();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapterMainActivity);

        presenter.requestDataFromServer();
        return view;
    }

    private void initDagger() {
        DaggerActivityComponent.builder()
                .appComponent(getAppComponent())
                .activityModule(new ActivityModule(this, this))
                .build()
                .inject(this);
    }

    private AppComponent getAppComponent() {
        return ((App) getActivity().getApplication()).getAppComponent();
    }

    @Override
    public void onItemClick(String source) {
        showDetails(source);
    }

    private void showDetails(String source) {
        RecipeDetailsFragment recipeDetailsFragment = new RecipeDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("source", source);
        recipeDetailsFragment.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_container, recipeDetailsFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void setDataToRecyclerView(ResponseListRecipes responseListRecipes) {
        List<Hit> hits = responseListRecipes.getmHits();
        adapterMainActivity.setRecipes(hits);
    }

    @Override
    public void onResponseFailure(Throwable e) {
        Toast.makeText(getActivity(), e.getMessage(), Toast.LENGTH_LONG).show();
    }
}
