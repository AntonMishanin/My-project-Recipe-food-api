package com.example.mvptraining.di.component;

import com.example.mvptraining.ui.RecipesListFragment;
import com.example.mvptraining.ui.main.MainActivity;
import com.example.mvptraining.di.PerActivity;
import com.example.mvptraining.di.module.ActivityModule;

import dagger.Component;

@PerActivity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    //void inject(MainActivity mainActivity);
   void inject(RecipesListFragment recipesListFragment);
}
