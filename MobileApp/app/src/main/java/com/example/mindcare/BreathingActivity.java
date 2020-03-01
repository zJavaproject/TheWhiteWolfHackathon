package com.example.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class BreathingActivity extends AppCompatActivity {
    TextView tvBreath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_breathing);
        tvBreath = findViewById(R.id.tvBreath);

        final ImageView img = findViewById(R.id.ivCircle);
        img.setScaleType(ImageView.ScaleType.FIT_START);

        tvBreath.setText("Wdech");
        final Animation anim = AnimationUtils.loadAnimation(this, R.anim.scale);
        img.startAnimation(anim);



    }
}
