package com.example.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CountingActivity extends AppCompatActivity {
    TextView tvNumber, tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting);
        tvNumber = findViewById(R.id.tvNumber);


        AnimateCounter animateCounter = new AnimateCounter.Builder(tvNumber)
                .setCount(1, 10, 0)
                .setDuration(18000)
                .build();
        animateCounter.execute();

    }
}
