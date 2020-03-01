package com.example.mindcare;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.StrictMode;
import android.os.UserHandle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private TextView firstNameError, nameError, emailError, passwordError, password2Error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

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

    public void openSignInForm(View view) throws JSONException {
        EditText imie = findViewById(R.id.EditTextFirstName);
        EditText nazwisko = findViewById(R.id.EditTextName);
        EditText email = findViewById(R.id.EditTextEmail);
        String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        EditText haslo = findViewById(R.id.EditTextPassword);
        EditText haslo2 = findViewById(R.id.EditTextPassword2);
        EditText phone = findViewById(R.id.editTextPhone);

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

            JSONObject userData = new JSONObject();
            userData.put("name", imie.getText().toString());
            userData.put("surname", nazwisko.getText().toString());
            userData.put("phone", phone.getText().toString());
            userData.put("email", email.getText().toString());
            userData.put("password", haslo.getText().toString());


            URL mainServerUrl;
            String mainServerUrlString = "http://192.168.43.239:8080/mobile_api/user-create/";

            HttpURLConnection urlConn;
            try {
                mainServerUrl = new URL(mainServerUrlString);
                urlConn = (HttpURLConnection) mainServerUrl.openConnection();

                urlConn.setRequestMethod("POST");

                byte[] postDataBytes = userData.toString().getBytes("UTF-8");

                urlConn.setRequestMethod("POST");
                urlConn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                urlConn.setDoOutput(true);
                urlConn.setDoInput(true);

                urlConn.getOutputStream().write(postDataBytes);

                int HttpResult = urlConn.getResponseCode();
                //HttpResponse response;
                System.out.println(HttpResult);



                InputStream ip = urlConn.getInputStream();
                BufferedReader br1 = new BufferedReader(new InputStreamReader(ip));
                StringBuilder response = new StringBuilder();
                String responseSingle = null;
                while ((responseSingle = br1.readLine()) != null)
                {
                    response.append(responseSingle);
                }
                String xx = response.toString();
                System.out.println(xx);

            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();


            }



            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }


}

