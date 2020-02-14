package com.example.mvptraining.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
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

    private String diet;
    private View view;
    private ProgressDialog progressDialog;

    public RecipesListFragment(String diet) {
        this.diet = diet;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_recipes_list, container, false);


        initDagger();
        showProgressDialog();

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapterMainActivity);

        String defaultRequestFood = "meat";
        presenter.requestDataFromServer(defaultRequestFood, diet);
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
    public void onItemClick(String source, String imageUrl) {
        showDetails(source, imageUrl);
    }

    private void showDetails(String source, String imageUrl) {
        RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString("source", source);
        bundle.putString("imageUrl", imageUrl);
        recipeDetailFragment.setArguments(bundle);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout_container, recipeDetailFragment);
        fragmentTransaction.addToBackStack(null).commit();
    }

    @Override
    public void setDataToRecyclerView(ResponseListRecipes responseListRecipes) {
        List<Hit> hits = responseListRecipes.getmHits();
        adapterMainActivity.setRecipes(hits);

        hideProgressDialog();
    }

    @Override
    public void onResponseFailure(Throwable e) {
        TextView textView = view.findViewById(R.id.text_no_signal);
        ImageView imageView = view.findViewById(R.id.image_no_signal);

        textView.setVisibility(View.VISIBLE);
        textView.setText(e.getMessage());
        imageView.setVisibility(View.VISIBLE);

        hideProgressDialog();
    }

    private void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(true);
        }
        progressDialog.show();
    }

    private void hideProgressDialog(){
        if(progressDialog !=null && progressDialog.isShowing()){
            progressDialog.cancel();
        }
    }
}
