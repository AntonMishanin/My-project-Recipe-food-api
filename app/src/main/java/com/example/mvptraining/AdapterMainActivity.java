package com.example.mvptraining;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class AdapterMainActivity extends RecyclerView.Adapter<AdapterMainActivity.Holder> {

    private List<Recipe> recipes = new ArrayList<>();

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.bind(position);
    }

    public void setRecipes(List<Hit> hits) {
        for (int i = 0; i < hits.size(); i++) {
            Recipe recipe = hits.get(i).getRecipe();
            recipes.add(recipe);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return recipes.size();
    }

     class Holder extends RecyclerView.ViewHolder {

        TextView labelTextView;
        ImageView image;


         Holder(@NonNull View itemView) {
            super(itemView);

            labelTextView = itemView.findViewById(R.id.label_textView);
            image = itemView.findViewById(R.id.imageView);
        }

         public void bind( int position) {
             labelTextView.setText(recipes.get(position).getLabel());

             Picasso.with(itemView.getContext())
                     .load(recipes.get(position).getImage())
                     .into(image);
         }
     }
}
