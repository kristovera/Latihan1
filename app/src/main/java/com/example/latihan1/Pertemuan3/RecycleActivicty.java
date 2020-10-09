package com.example.latihan1.Pertemuan3;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import com.example.latihan1.Adapter.MahasiswaRecyclerAdapter;
import com.example.latihan1.Model.Mahasiswa;
import com.example.latihan1.R;

class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvLatihan);
        MahasiswaRecyclerAdapter mahasiswaRecyclerAdapter;
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        Mahasiswa m1 = new Mahasiswa("Baba","11802001","08902415780");
        Mahasiswa m2 = new Mahasiswa("Mike","72140001","0878219020304");


        mahasiswaList.add(m1);
        mahasiswaList.add(m2);


        mahasiswaRecyclerAdapter = new MahasiswaRecyclerAdapter(RecyclerActivity.this);
        mahasiswaRecyclerAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
        rv.setAdapter(mahasiswaRecyclerAdapter);

    }
}