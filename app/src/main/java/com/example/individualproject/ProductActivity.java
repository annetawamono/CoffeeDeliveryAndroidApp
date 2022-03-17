package com.example.individualproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class ProductActivity extends AppCompatActivity {

    TextView txtName;
    ImageView imageView;
    TextView txtDescription;
    EditText editQty;
    EditText editShots;
    RadioGroup radioGroup;
    Button btnCheckout;
    Order myOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        txtName = findViewById(R.id.txtCoffeeName);
        txtDescription = findViewById(R.id.txtCoffeeDescription);
        imageView = findViewById(R.id.imgCoffeeBig);
        btnCheckout = findViewById(R.id.btnCheckout);

        Intent myIntent = getIntent();
        String name = myIntent.getStringExtra("NAME");
        String image = myIntent.getStringExtra("IMAGE");
        String description = myIntent.getStringExtra("DESCRIPTION");

        txtName.setText(name);
        txtDescription.setText(description);

        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(image);
        Glide.with(this).load(storageReference).into(imageView);

        /* Pass user input into an Order object */
        btnCheckout.setOnClickListener(view -> {
            myOrder = new Order();

            editQty = findViewById(R.id.editQty);
            editShots = findViewById(R.id.editShots);

            int qty = Integer.parseInt(editQty.getText().toString());
            myOrder.setQty(qty);

            int shots = Integer.parseInt(editShots.getText().toString());
            myOrder.setShots(shots);

            radioGroup = findViewById(R.id.rGrpSize);
            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int checkedBtnId) {
                    switch (checkedBtnId) {
                        case R.id.rBtnSmall:
                            myOrder.setSize(Order.Size.SMALL);
                            break;
                        case R.id.rBtnMedium:
                            myOrder.setSize(Order.Size.MEDIUM);
                            break;
                        case R.id.rBtnLarge:
                            myOrder.setSize(Order.Size.LARGE);
                            break;
                    }
                }
            });

            /* Go to checkout page and pass order details */
            Intent myCheckoutIntent = new Intent(this, CheckoutActivity.class);
            myCheckoutIntent.putExtra("QTY", myOrder.getQty());
            myCheckoutIntent.putExtra("SHOTS", myOrder.getShots());
            myCheckoutIntent.putExtra("SIZE", myOrder.getSize());

            startActivity(myCheckoutIntent);
        });

    }
}