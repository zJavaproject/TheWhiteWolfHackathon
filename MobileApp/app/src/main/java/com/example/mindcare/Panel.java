package com.example.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Panel extends AppCompatActivity {

    Button btnAttack;
    ImageView ivMyProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        btnAttack = findViewById(R.id.btnAttack);
        ivMyProfile = findViewById(R.id.ivMyProfile);

        btnAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attackActivity = new Intent(Panel.this, AttackActivity.class);
                startActivity(attackActivity);


            }
        });

        ivMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent profileIntent = new Intent(Panel.this, UserViewActivity.class);
                startActivity(profileIntent);
            }
        });

    }

    public void openMoodForm(View view) {
        Intent intent = new Intent(this, mood.class);
        startActivity(intent);

    }

    public void logInView(View view) {
        Intent intent = new Intent(this, SignIn.class);
        startActivity(intent);
    }

}
