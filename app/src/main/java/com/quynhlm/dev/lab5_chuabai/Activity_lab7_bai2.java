package com.quynhlm.dev.lab5_chuabai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class Activity_lab7_bai2 extends AppCompatActivity {

    ImageView imgView;
    Button btnFast;
    Button btnMedium;
    Button btnSlow;
    Button btnOff;
    private static final long DURATION = 500;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quat);

        imgView = findViewById(R.id.imgQuat);
        btnFast = findViewById(R.id.btnFast);
        btnMedium = findViewById(R.id.btnmedium);
        btnSlow = findViewById(R.id.btnslow);
        btnOff = findViewById(R.id.btnoff);

        btnFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(50);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(500);
            }
        });

        btnSlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startFan(1000);
            }
        });

        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopFan();
            }
        });

        startFan(DURATION);
    }

    private void startFan(long time) {
        Runnable run = new Runnable() {
            @Override
            public void run() {
                imgView.animate().rotationBy(360).withEndAction(this).setDuration(time).setInterpolator(new LinearInterpolator()).start();
            }
        };
        imgView.animate().rotationBy(360).withEndAction(run).setDuration(time).setInterpolator(new LinearInterpolator()).start();
    }

    private void stopFan() {
        imgView.animate().cancel();
    }
}
