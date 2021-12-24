package com.fkomuniku.testcoding_qtasnim.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaksi {
    public void Transaksi() {

    }

    public void Transaksi(String nama_barang, String jenis_barang, String tanggal_transaksi, String stok){
        this.nama_barang = nama_barang;
        this.jenis_barang = jenis_barang;
        this.tanggal_transaksi = tanggal_transaksi;
        this.stok = stok;
    }

    @Expose
    @SerializedName("nama_barang") private String nama_barang;
    @Expose
    @SerializedName("jenis_barang") private String jenis_barang;
    @Expose
    @SerializedName("tanggal_transaksi") private String tanggal_transaksi;
    @Expose
    @SerializedName("stok") private String stok;

    public String getNama_barang(){ return nama_barang; }
    public String getJenis_barang(){ return jenis_barang; }
    public String getTanggal_transaksi(){ return tanggal_transaksi; }
    public String getStok(){ return stok; }

    public void setNama_barang(){ this.nama_barang = nama_barang; }
    public void setJenis_barang(){ this.jenis_barang = jenis_barang; }
    public void setTanggal_transaksi(){ this.tanggal_transaksi = tanggal_transaksi; }
    public void setStok(){ this.stok = stok; }
}
