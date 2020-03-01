package com.example.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;

import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.widget.ImageView;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {

    Button btnAttack;
    ImageView ivMyProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnAttack = findViewById(R.id.btnAttack);
        ivMyProfile = findViewById(R.id.ivMyProfile);

        btnAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attackIntent = new Intent(MainActivity.this, AttackActivity.class);
                startActivity(attackIntent);
            }
        });

        ivMyProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myProfileIntent = new Intent(MainActivity.this, MyProfileActivity.class);
                startActivity(myProfileIntent);
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
