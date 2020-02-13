package com.example.mvptraining.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mvptraining.R;

public class RecipeDetailsFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_recipe_details, container, false);

        TextView textView = v.findViewById(R.id.textView);
        textView.setText(getArguments().getString("source", "Testing"));

        return v;
    }
}
