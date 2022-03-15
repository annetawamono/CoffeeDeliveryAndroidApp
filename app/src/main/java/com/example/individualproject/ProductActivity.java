package com.example.individualproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ProductActivity extends AppCompatActivity {

    TextView txtName;
    ImageView imageView;
    TextView txtDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        txtName = findViewById(R.id.txtCoffeeName);
        txtDescription = findViewById(R.id.txtCoffeeDescription);
        imageView = findViewById(R.id.imgCoffeeBig);

        Intent myIntent = getIntent();
        String name = myIntent.getStringExtra("NAME");
        String image = myIntent.getStringExtra("IMAGE");
        String description = myIntent.getStringExtra("DESCRIPTION");

        txtName.setText(name);
        txtDescription.setText(description);

        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(image);
        Glide.with(this).load(storageReference).into(imageView);
    }
}