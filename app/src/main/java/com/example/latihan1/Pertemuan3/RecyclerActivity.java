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

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler2);

        RecyclerView rv = (RecyclerView)findViewById(R.id.rvLatihan);
        MahasiswaRecyclerAdapter mahasiswaRecyclerAdapter;
        List<Mahasiswa> mahasiswaList = new ArrayList<Mahasiswa>();

        Mahasiswa m1 = new Mahasiswa("Supri", "721800001", "0823456778100");
        Mahasiswa m2 = new Mahasiswa("Evan", "72180190", "08142567103081");
        Mahasiswa m3 = new Mahasiswa("Budi", "72180188", "0813456281900");

        mahasiswaList.add(m1);
        mahasiswaList.add(m2);
        mahasiswaList.add(m3);

        List<Mahasiswa> mahasiswaListDebug = new ArrayList<Mahasiswa>();

        mahasiswaRecyclerAdapter = new MahasiswaRecyclerAdapter(RecyclerActivity.this);
        mahasiswaRecyclerAdapter.setMahasiswaList(mahasiswaList);

        rv.setLayoutManager(new LinearLayoutManager(RecyclerActivity.this));
        rv.setAdapter(mahasiswaRecyclerAdapter);

    }
}