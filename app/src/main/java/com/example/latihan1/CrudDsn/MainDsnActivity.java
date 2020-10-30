package com.example.latihan1.CrudDsn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.latihan1.Crud.HapusMhsActivity;
import com.example.latihan1.Crud.MahasiswaAddActivity;
import com.example.latihan1.Crud.MahasiswaGetAllActivity;
import com.example.latihan1.Crud.MainMhsActivity;
import com.example.latihan1.R;

public class MainDsnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dsn);

        //variabel
        Button btnLihatDsn = (Button)findViewById(R.id.buttonGetDsn);
        Button btnTambahDsn = (Button)findViewById(R.id.buttonAddDsn);
        Button btnDelDsn = (Button)findViewById(R.id.buttonDelDsn);

        //action
        btnLihatDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDsnActivity.this,DosenGetAllActivity.class);
                startActivity(intent);
            }
        });

        btnTambahDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDsnActivity.this, DosenAddActivity.class);
                startActivity(intent);
            }
        });

        btnDelDsn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainDsnActivity.this, HapusDsnActivity.class);
                startActivity(intent);
            }
        });
    }
}
