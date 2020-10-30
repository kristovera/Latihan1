package com.example.latihan1.Pertemuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.latihan1.R;

public class PrefActivity extends AppCompatActivity {
    String isiLogin = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pref);

        final Button btnPref = (Button)findViewById(R.id.btnPref);

        final SharedPreferences pref = PrefActivity.this.getSharedPreferences("pref_file",MODE_PRIVATE);
        final SharedPreferences.Editor editor = pref.edit();

        //membaca pref
         isiLogin = pref.getString("isiLogin","0");
        if(isiLogin =="1") {
            btnPref.setText("Logout");
        } else{
            btnPref.setText("Login");

            }
        btnPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isiLogin = pref.getString("isiLogin","0");
                if(isiLogin =="0"){
                    editor.putString("isiLogin","1");
                    btnPref.setText("Logout");
                }else{
                    editor.putString("isiLogin","0");
                    btnPref.setText("Login");
                }
                editor.commit();
            }
        });
        }
    }
