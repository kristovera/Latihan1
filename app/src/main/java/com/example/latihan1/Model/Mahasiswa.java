package com.example.latihan1.Model;

import java.util.List;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String no_telepon;

    public Mahasiswa(String nama, String nim, String no_telepon) {
        this.nama = nama;
        this.nim = nim;
        this.no_telepon = no_telepon;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNo_telepon() {
        return no_telepon;
    }

    public void setNo_telepon(String no_telepon) {
        this.no_telepon = no_telepon;
    }

    public void setMahasiswaList(List<Mahasiswa> mahasiswaList) {
    }
}