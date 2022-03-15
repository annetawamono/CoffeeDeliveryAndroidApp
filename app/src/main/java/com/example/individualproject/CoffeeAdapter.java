package com.example.individualproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CoffeeAdapter extends FirebaseRecyclerAdapter<Coffee, CoffeeAdapter.MyViewHolder> {

    public CoffeeAdapter(FirebaseRecyclerOptions<Coffee> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CoffeeAdapter.MyViewHolder holder, int position, @NonNull Coffee model) {
        holder.txtName.setText(model.getName());
        holder.txtIngredients.setText(model.getIngredients());

        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(model.getImage());
        Glide.with(holder.itemView.getContext()).load(storageReference).into(holder.imageView);

        holder.btnOrder.setOnClickListener(view -> {
            Intent myIntent = new Intent(holder.itemView.getContext(), ProductActivity.class);

            myIntent.putExtra("NAME", model.getName());
            myIntent.putExtra("DESCRIPTION", model.getDescription());
            myIntent.putExtra("IMAGE", model.getImage());

            holder.itemView.getContext().startActivity(myIntent);
        });

    }

    @NonNull
    @Override
    public CoffeeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new MyViewHolder(layoutInflater, parent);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;
        TextView txtIngredients;
        ImageView imageView;
        Button btnOrder;

        public MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_layout, parent, false));

            txtName = itemView.findViewById(R.id.txtName);
            imageView = itemView.findViewById(R.id.imgCoffee);
            txtIngredients = itemView.findViewById(R.id.txtIngredients);
            btnOrder = itemView.findViewById(R.id.btnOrder);

        }
    }
}
