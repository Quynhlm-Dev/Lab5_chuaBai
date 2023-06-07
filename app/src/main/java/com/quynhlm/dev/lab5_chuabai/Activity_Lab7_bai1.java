package com.quynhlm.dev.lab5_chuabai;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_Lab7_bai1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ImageView imglogo = findViewById(R.id.imglogo);
        TextView textView = findViewById(R.id.txttextView);

        Animation amin = AnimationUtils.loadAnimation(this,R.anim.test_anim1);
        imglogo.startAnimation(amin);


        Animation amin2 = AnimationUtils.loadAnimation(this,R.anim.test_anim2);
        textView.startAnimation(amin);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Activity_Lab7_bai1.this, Activity_dang_nhap.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}