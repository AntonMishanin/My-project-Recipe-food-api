package com.example.mvptraining.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.mvptraining.R;
import com.example.mvptraining.ui.RecipesListFragment;

public class MainActivity extends AppCompatActivity {

    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        RecipesListFragment recipesListFragment = new RecipesListFragment();
        fragmentTransaction.replace(R.id.frame_layout_container, recipesListFragment);
        fragmentTransaction.commit();
    }
}
