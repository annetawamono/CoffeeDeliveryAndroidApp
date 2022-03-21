package com.example.individualproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {
    TextView txtOrder;
    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        txtOrder = findViewById(R.id.txtOrder);
        btnPay = findViewById(R.id.btnPaynow);

        Intent myCheckoutIntent = getIntent();

        /* Building the order string */
        StringBuilder sb = new StringBuilder();

        sb.append(myCheckoutIntent.getIntExtra("QTY", 1));
        sb.append("x ");
        sb.append(myCheckoutIntent.getStringExtra("NAME"));
        sb.append("\n");
        sb.append(myCheckoutIntent.getIntExtra("SHOTS", 1));
        sb.append("x shots of Signature Espresso");
        sb.append("\n");
//        sb.append("Size: ");
//        sb.append(myCheckoutIntent.getStringExtra("SIZE"));

        txtOrder.setText(sb.toString());

        /* Move to Delivery page */

        btnPay.setOnClickListener(view -> {
            Intent myDeliveryIntent = new Intent(this, DeliveryActivity.class);
            startActivity(myDeliveryIntent);
        });

    }
}