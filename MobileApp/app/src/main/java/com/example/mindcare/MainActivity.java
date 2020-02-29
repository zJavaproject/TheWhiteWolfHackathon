package com.example.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
