package com.example.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Panel extends AppCompatActivity {

    Button btnAttack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_panel);


        btnAttack = findViewById(R.id.btnAttack);

        btnAttack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attackIntent = new Intent(Panel.this, AttackActivity.class);
                startActivity(attackIntent);


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
