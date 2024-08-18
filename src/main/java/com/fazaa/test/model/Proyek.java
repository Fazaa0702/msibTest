package com.fazaa.test.model;
import java.sql.Date;
import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proyek")
public class Proyek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama_proyek")
    private String namaProyek;

    @Column(name = "client")
    private String client;

    @Column(name = "tgl_mulai")
    private Date tglMulai;

    @Column(name = "tgl_selesai")
    private Date tglSelesai;

    @Column(name = "pimpinan_proyek")
    private String pimpinanProyek;

    @Column(name = "keterangan")
    private String keterangan;

    @Column(name = "created_at")
    private Timestamp createdAt;

    @ManyToOne
    @JoinColumn(name = "lokasi_id")
    private Lokasi lokasi;

    // Getter dan Setter untuk id
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Getter dan Setter untuk namaProyek
    public String getNamaProyek() {
        return namaProyek;
    }

    public void setNamaProyek(String namaProyek) {
        this.namaProyek = namaProyek;
    }

    // Getter dan Setter untuk client
    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    // Getter dan Setter untuk tglMulai
    public Date getTglMulai() {
        return tglMulai;
    }

    public void setTglMulai(Date tglMulai) {
        this.tglMulai = tglMulai;
    }

    public Date getTglSelesai() {
        return tglSelesai;
    }

    public void setTglSelesai(Date tglSelesai) {
        this.tglSelesai = tglSelesai;
    }

    public String getPimpinanProyek() {
        return pimpinanProyek;
    }

    public void setPimpinanProyek(String pimpinanProyek) {
        this.pimpinanProyek = pimpinanProyek;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Lokasi getLokasi() {
        return lokasi;
    }

    public void setLokasi(Lokasi lokasi) {
        this.lokasi = lokasi;
    }
}
