package com.example.mindcare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class AttackActivity extends AppCompatActivity {
    Button btnCounting;
    ImageButton btnBreathing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attack);

        btnBreathing = findViewById(R.id.btnBreath);
        btnCounting = findViewById(R.id.btnCounting);
        btnBreathing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent breathIntent = new Intent(AttackActivity.this, BreathingActivity.class);
                startActivity(breathIntent);
            }
        });
        btnCounting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent countingIntent = new Intent(AttackActivity.this, CountingActivity.class);
                startActivity(countingIntent);
            }
        });
    }
}
