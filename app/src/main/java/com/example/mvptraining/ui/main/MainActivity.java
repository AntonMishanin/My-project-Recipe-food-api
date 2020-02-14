package com.example.mvptraining.ui.main;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.mvptraining.R;
import com.example.mvptraining.ui.RecipesListFragment;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FragmentTransaction fragmentTransaction;
    DrawerLayout drawerLayout;
    FragmentManager fragmentManager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void init() {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        RecipesListFragment recipesListFragment = new RecipesListFragment(null);
        fragmentTransaction.replace(R.id.frame_layout_container, recipesListFragment);
        fragmentTransaction.commit();

        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        String diet = null;
        switch (menuItem.getItemId()) {
            case R.id.balanced:
                diet = "balanced";
                break;
            case R.id.high_protein:
                diet = "high-protein";
                break;
            case R.id.high_fiber:
                diet = "high-fiber";
                //do not work
                break;
            case R.id.low_fat:
                diet = "low-fat";
                break;
            case R.id.low_carb:
                diet = "low-carb";
                break;
            case R.id.low_sodium:
                diet = "low-sodium";
                //do not work
                break;
        }
        Fragment touchFragment = new RecipesListFragment(diet);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_layout_container, touchFragment)
                .addToBackStack(null)
                .commit();

        return true;
    }
}
