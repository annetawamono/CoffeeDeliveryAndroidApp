package com.example.individualproject;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class CoffeeAdapter extends FirebaseRecyclerAdapter<Coffee, CoffeeAdapter.MyViewHolder> {

    public CoffeeAdapter(FirebaseRecyclerOptions<Coffee> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull CoffeeAdapter.MyViewHolder holder, int position, @NonNull Coffee model) {
        holder.txtName.setText(model.getName());
    }

    @NonNull
    @Override
    public CoffeeAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new MyViewHolder(layoutInflater, parent);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtName;

        public MyViewHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.row_layout, parent, false));

            txtName = itemView.findViewById(R.id.txtName);

        }
    }
}
