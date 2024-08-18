package com.fazaa.test.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lokasi")
public class Lokasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_lokasi")
    private String namaLokasi;

    @Column(name = "provinsi")
    private String provinsi;

    @Column(name = "kota_kabupaten")
    private String kotaKabupaten;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @Column(name = "negara")
    private String negara;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamaLokasi() {
        return namaLokasi;
    }

    public void setNamaLokasi(String namaLokasi) {
        this.namaLokasi = namaLokasi;
    }

    public String getProvinsi() {
        return provinsi;
    }

    public void setProvinsi(String provinsi) {
        this.provinsi = provinsi;
    }

    public String getKotaKabupaten() {
        return kotaKabupaten;
    }

    public void setKotaKabupaten(String kotaKabupaten) {
        this.kotaKabupaten = kotaKabupaten;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public String getNegara() {
        return negara;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }
}
