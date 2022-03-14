package com.example.individualproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class MainActivity extends AppCompatActivity {

    private Query query;
    private CoffeeAdapter adapter;
    private RecyclerView rView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        query = FirebaseDatabase.getInstance().getReference().child("hot coffee");

        FirebaseRecyclerOptions<Coffee> options = new FirebaseRecyclerOptions.Builder<Coffee>()
                .setQuery(query, Coffee.class)
                .build();

        adapter = new CoffeeAdapter(options);

        rView = findViewById(R.id.rView);
        rView.setAdapter(adapter);
        rView.setLayoutManager(new GridLayoutManager(this, 2));
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }
}