package com.example.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class SignIn extends AppCompatActivity {

    private TextView emailError, passwordError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        emailError = findViewById(R.id.TextViewEmailError);
        emailError.setVisibility(View.GONE);
        passwordError = findViewById(R.id.TextViewPasswordError);
        passwordError.setVisibility(View.GONE);

    }

    public void openMain(View view) {

        EditText email = findViewById(R.id.EditTextEmail);
        String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        EditText haslo = findViewById(R.id.EditTextPassword);

        if (email.getText().toString().trim().equals("") || haslo.getText().toString().trim().equals("")){
            if (email.getText().toString().trim().equals("")) {
                email.setError("Podaj email!");
                emailError.setVisibility(View.VISIBLE);
            }else if (!Pattern.matches(EMAIL_REGEX, email.getText())){
                email.setError("Zły email!");
                emailError.setVisibility(View.VISIBLE);
            }else{
                emailError.setVisibility(View.GONE);
            }
            if (haslo.getText().toString().trim().equals("")) {
                haslo.setError("Podaj hasło!");
                passwordError.setVisibility(View.VISIBLE);
            }else{
                passwordError.setVisibility(View.GONE);
            }
        }else {
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
        }

    }

    public void openRegisterForm(View view) {
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }


}
