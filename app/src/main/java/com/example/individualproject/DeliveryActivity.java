package com.example.individualproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class DeliveryActivity extends AppCompatActivity {
    TextView txtCountdown;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);

        txtCountdown = findViewById(R.id.txtCountdown);
        startTimer();
    }

    /*
     * startTimer(): will create a new CountDownTimer and set it to 30 seconds and 1 second intervals.
     * params:
     */
    private void startTimer() {
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long l) {
                updateCountdownText(l);
            }

            @Override
            public void onFinish() {
                // TODO: Add callback to Toast and then go to Main page
//                Intent myMainIntent = new Intent(DeliveryActivity.this, MainActivity.class);
                Toast mToast = Toast.makeText(DeliveryActivity.this, "Your delivery has arrived", Toast.LENGTH_LONG);
//                mToast.show();
//                mToast.addCallback(Toast.Callback);
            }
        }.start();
    }

    /*
     * updateCountdownText(): will setText() of the countdown timer to show time left.
     * params: long time => time left in the countdown
     */
    private void updateCountdownText(long time) {
        int minutes = (int) (time / 1000) / 60;
        int seconds = (int) (time / 1000) % 60;

        String timeToDisplay = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);

        txtCountdown.setText(timeToDisplay);
    }
}