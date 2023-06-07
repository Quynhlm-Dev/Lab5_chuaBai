package com.quynhlm.dev.lab5_chuabai;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class Activity_Lab7_bai4 extends AppCompatActivity {


    ImageView imgView;
    Button btnFast;
    Button btnMedium;
    Button btnSlow;
    Button btnOff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7_bai4);

        imgView = findViewById(R.id.imgQuat);
        btnFast = findViewById(R.id.btnFast);
        btnMedium = findViewById(R.id.btnmedium);
        btnSlow = findViewById(R.id.btnslow);
        btnOff = findViewById(R.id.btnoff);

        Animation animation = AnimationUtils.loadAnimation(Activity_Lab7_bai4.this, R.anim.test_anim1);
        imgView.startAnimation(animation);

        btnSlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(Activity_Lab7_bai4.this, R.anim.test_anim2);
                imgView.startAnimation(animation);
            }
        });
        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(Activity_Lab7_bai4.this, R.anim.test_anim3);
                imgView.startAnimation(animation);
            }
        });
        btnFast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(Activity_Lab7_bai4.this, R.anim.test_anim4);
                imgView.startAnimation(animation);
            }
        });
        btnOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgView.animate().cancel();
            }
        });
    }
}