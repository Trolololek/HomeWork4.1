package com.example.homework41;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View ballView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ballView = findViewById(R.id.ball);
        animateBall();
    }

    private void animateBall() {
        // Calculate the maximum X and Y coordinates of the field
        int fieldWidth = getResources().getDisplayMetrics().widthPixels;
        int fieldHeight = getResources().getDisplayMetrics().heightPixels;

        // Calculate the maximum translation values for X and Y directions
        float maxX = fieldWidth - ballView.getWidth();
        float maxY = fieldHeight - ballView.getHeight();

        // Create ObjectAnimators for X and Y translations
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(ballView, "translationX", 0f, maxX);
        animatorX.setDuration(2000); // Adjust the duration as needed
        animatorX.setRepeatCount(ValueAnimator.INFINITE);
        animatorX.setRepeatMode(ValueAnimator.REVERSE);
        animatorX.setInterpolator(new LinearInterpolator());

        ObjectAnimator animatorY = ObjectAnimator.ofFloat(ballView, "translationY", 0f, maxY);
        animatorY.setDuration(3000); // Adjust the duration as needed
        animatorY.setRepeatCount(ValueAnimator.INFINITE);
        animatorY.setRepeatMode(ValueAnimator.REVERSE);
        animatorY.setInterpolator(new LinearInterpolator());

        // Start both X and Y animations simultaneously
        animatorX.start();
        animatorY.start();
    }
}
