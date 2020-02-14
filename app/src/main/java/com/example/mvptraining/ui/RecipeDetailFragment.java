package com.example.mvptraining.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mvptraining.R;
import com.squareup.picasso.Picasso;

public class RecipeDetailFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_recipe_details, container, false);

        TextView textView = v.findViewById(R.id.title_detail_view);
        ImageView imageView = v.findViewById(R.id.image_detail_view);
        textView.setText(getArguments().getString("source", "Testing"));

        Picasso.with(getActivity())
                .load(getArguments().getString("imageUrl", null))
                .into(imageView);

        return v;
    }
}
