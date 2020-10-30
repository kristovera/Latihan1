package com.example.latihan1.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MataKuliah {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("kode")
    @Expose
    private String kode;

    @SerializedName("hari")
    @Expose
    private String hari;

    @SerializedName("sesi")
    @Expose
    private String sesi;

    @SerializedName("sks")
    @Expose
    private String sks;

    @SerializedName("nim_progmob")
    @Expose
    private String nim_progmob;

    public MataKuliah(String id, String nama, String kode, String hari, String sesi, String sks, String nim_progmob) {
        this.id = id;
        this.nama = nama;
        this.kode = kode;
        this.hari = hari;
        this.sesi = sesi;
        this.sks = sks;
        this.nim_progmob = nim_progmob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getSesi() {
        return sesi;
    }

    public void setSesi(String sesi) {
        this.sesi = sesi;
    }

    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }

    public String getNim_progmob() {
        return nim_progmob;
    }

    public void setNim_progmob(String nim_progmob) {
        this.nim_progmob = nim_progmob;
    }
}

