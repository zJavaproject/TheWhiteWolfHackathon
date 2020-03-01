package com.example.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class MyProfileActivity extends AppCompatActivity {
    ImageView ivMyProfile;
    TextView tvName, tvSurname, tvMail, tvPhone, tvDoctor, tvDoctorsName;
    Button btnAddDoctor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        ivMyProfile = findViewById(R.id.ivAvatar);
        tvName = findViewById(R.id.tvName);
        tvSurname = findViewById(R.id.tvSurname);
        tvMail = findViewById(R.id.tvMail);
        tvPhone = findViewById(R.id.tvPhone);
        btnAddDoctor = findViewById(R.id.btnAddDoctor);
//        tvDoctor =

        InputStream is = getResources().openRawResource(R.raw.user_data);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String jsonString = writer.toString();

        try {
            JSONObject obj = new JSONObject(jsonString);
            tvName.setText(obj.get("name").toString());
            tvSurname.setText(obj.get("surname").toString());
            tvMail.setText(obj.get("email").toString());
            tvPhone.setText(obj.get("phone").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        btnAddDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
