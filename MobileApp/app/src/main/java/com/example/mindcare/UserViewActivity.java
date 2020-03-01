package com.example.mindcare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class UserViewActivity extends AppCompatActivity {
    ImageView ivMyProfile;
    TextView tvName, tvSurname, tvMail, tvPhone, tvDoctor, tvDoctorsName;
    Button btnAddDoctor;
    private String m_Text = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);

        ivMyProfile = findViewById(R.id.ivAvatar);
        tvName = findViewById(R.id.tvName);
        tvSurname = findViewById(R.id.tvSurname);
        tvMail = findViewById(R.id.tvMail);
        tvPhone = findViewById(R.id.tvPhone);
        btnAddDoctor = findViewById(R.id.btnAddDoctor);
        tvDoctor = findViewById(R.id.tvDoctor);
        tvDoctorsName = findViewById(R.id.tvDoctorsName);

        tvDoctor.setVisibility(View.INVISIBLE);
        tvDoctorsName.setVisibility(View.INVISIBLE);


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
                AlertDialog.Builder builder = new AlertDialog.Builder(UserViewActivity.this);
                builder.setTitle("Numer ID Lekarza");


                final EditText input = new EditText(UserViewActivity.this);
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                builder.setView(input);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        m_Text = input.getText().toString();
                        tvDoctor.setVisibility(View.VISIBLE);
                        tvDoctor.setText("Twój terapeuta:");
                        tvDoctorsName.setVisibility(View.VISIBLE);
                        tvDoctorsName.setText("Piotr Psycholog");
                        btnAddDoctor.setText("Zmień lekarza");



                        //TODO get z id lekarza i id pacjenta na serwer
//                        new MyTask().execute();

                    }
                });
                builder.setNegativeButton("Anuluj", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.show();

            }
        });

    }

    private class MyTask extends AsyncTask<Void, Void, Void> {
        String result;
        HttpURLConnection conn = null;
        JSONObject obj = null;
        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("http://192.168.43.138:8080/mobile_api/user-update/?id_doctor=" + m_Text + "&id_user=1");
                //System.out.println();
                conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("GET");
//                            conn.setConnectTimeout(5000);

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuilder sb = new StringBuilder();
                obj = new JSONObject(sb.toString());
                System.out.println(obj);

                while((line = br.readLine()) != null){
                    sb.append(line);
                }
                br.close();
            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
//                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
//                String stringBuffer;
//                String string = "";
//                while ((stringBuffer = bufferedReader.readLine()) != null){
//                    string = String.format("%s%s", string, stringBuffer);
//                }
//                bufferedReader.close();
//                result = string;
//            } catch (IOException e){
//                e.printStackTrace();
//                result = e.toString();
//            }
            return null;
        }
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
