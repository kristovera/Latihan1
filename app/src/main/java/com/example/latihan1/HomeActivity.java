package com.example.latihan1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.latihan1.Crud.MainMhsActivity;
import com.example.latihan1.CrudDsn.MainDsnActivity;
import com.example.latihan1.CrudMatkul.MainMatkulActivity;
import com.example.latihan1.Model.User;
import com.example.latihan1.Pertemuan3.ListActivity;
import com.example.latihan1.Pertemuan6.LoginActivity;
import com.example.latihan1.Pertemuan6.PrefActivity;

import com.example.latihan1.R;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ProgressDialog pd;
    List<User> users;
    SharedPreferences session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //variabel
        final TextView txtView = (TextView) findViewById(R.id.mainActivityTextView);
        Button btnDataMhs = (Button) findViewById(R.id.btnDataMhs);
        Button btnMk = (Button) findViewById(R.id.btnMk);
        Button btnDsn = (Button) findViewById(R.id.btnDsn);
        Button btnLogout = (Button) findViewById(R.id.btnLogout);


        //action


        btnDataMhs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainMhsActivity.class);
                startActivity(intent);
            }
        });

        btnDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, MainDsnActivity.class);
                startActivity(intent);
            }
        });

        btnMk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, TrackerActivity.class);
                startActivity(intent);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = session.edit();
                editor.clear();
                editor.apply();
                finish();
                Intent Intent = new Intent(HomeActivity.this, LoginActivity.class);

                startActivity(Intent);
            }
        });
    }
}


