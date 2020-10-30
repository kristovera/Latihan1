package com.example.latihan1.CrudMatkul;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.latihan1.CrudDsn.DosenAddActivity;
import com.example.latihan1.CrudDsn.DosenGetAllActivity;
import com.example.latihan1.CrudDsn.HapusDsnActivity;
import com.example.latihan1.R;

public class MainMatkulActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_matkul);

        //variabel
        Button btnLihatMatkul = (Button)findViewById(R.id.buttonGetAllMatkul);
        Button btnTambahMatkul = (Button)findViewById(R.id.buttonAddMatkul);
        Button btnDelMatkul = (Button)findViewById(R.id.buttonDelMatkul);

        //action
        btnLihatMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMatkulActivity.this, MatkulGetAllActivity.class);
                startActivity(intent);
            }
        });

        btnTambahMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMatkulActivity.this, MatkulAddActivity.class);
                startActivity(intent);
            }
        });

        btnDelMatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMatkulActivity.this, HapusMatkulActivity.class);
                startActivity(intent);
            }
        });
    }
}
