package com.example.latihan1.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("nimnik")
    @Expose
    private String nimnik;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("admin")
    @Expose
    private String admin;

    public User(String id, String nama, String nimnik, String password, String admin) {
        this.id = id;
        this.nama = nama;
        this.nimnik = nimnik;
        this.password = password;
        this.admin = admin;
    }

    public User(String nama, String nimnik, String password, String is_admin) {
        this.nama = nama;
        this.nimnik = nimnik;
        this.password = password;
        this.admin = admin;
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

    public String getNimnik() {
        return nimnik;
    }

    public void setNimnik(String nimnik) {
        this.nimnik = nimnik;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }
}


