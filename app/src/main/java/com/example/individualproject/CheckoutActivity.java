package com.example.individualproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class CheckoutActivity extends AppCompatActivity {
    TextView txtOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        // TODO: Get extras and put it int txtOrders
        txtOrder = findViewById(R.id.txtOrder);

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
    }
}