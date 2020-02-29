package com.example.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private TextView firstNameError, nameError, emailError, passwordError, password2Error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstNameError = findViewById(R.id.TextViewFirstNameError);
        firstNameError.setVisibility(View.GONE);
        nameError = findViewById(R.id.TextViewNameError);
        nameError.setVisibility(View.GONE);
        emailError = findViewById(R.id.TextViewEmailError);
        emailError.setVisibility(View.GONE);
        passwordError = findViewById(R.id.TextViewPasswordError);
        passwordError.setVisibility(View.GONE);
        password2Error = findViewById(R.id.TextViewPassword2Error);
        password2Error.setVisibility(View.GONE);

    }

    public void openSignInForm(View view) {
        EditText imie = findViewById(R.id.EditTextFirstName);
        EditText nazwisko = findViewById(R.id.EditTextName);
        EditText email = findViewById(R.id.EditTextEmail);
        String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        EditText haslo = findViewById(R.id.EditTextPassword);
        EditText haslo2 = findViewById(R.id.EditTextPassword2);

        if (email.getText().toString().trim().equals("") || haslo.getText().toString().trim().equals("") || imie.getText().toString().trim().equals("")
        || nazwisko.getText().toString().trim().equals("") || haslo2.getText().toString().trim().equals("") ||
                haslo.getText().toString().trim().equals("") != haslo2.getText().toString().trim().equals("")){
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
            if (haslo2.getText().toString().trim().equals("")) {
                haslo2.setError("Podaj hasło!");
                password2Error.setVisibility(View.VISIBLE);
            }else{
                password2Error.setVisibility(View.GONE);
            }
            if (haslo.getText().toString().trim().equals("") != haslo2.getText().toString().trim().equals("")){
                haslo2.setError("Hasła muszą być identyczne!");
            }
            if (imie.getText().toString().trim().equals("")) {
                imie.setError("Podaj imię!");
                firstNameError.setVisibility(View.VISIBLE);
            }else{
                firstNameError.setVisibility(View.GONE);
            }
            if (nazwisko.getText().toString().trim().equals("")) {
                nazwisko.setError("Podaj nazwisko!");
                nameError.setVisibility(View.VISIBLE);
            }else{
                nameError.setVisibility(View.GONE);
            }
        }else {
            Intent intent = new Intent(this, SignIn.class);
            startActivity(intent);
        }
    }
}

