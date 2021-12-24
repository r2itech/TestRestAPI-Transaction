package com.fkomuniku.testcoding_qtasnim.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Barang {
    public void Barang() {

    }

    public void Barang(String nama_barang, String jenis_barang, String stok){
        this.nama_barang = nama_barang;
        this.jenis_barang = jenis_barang;
        this.stok = stok;
    }

    @Expose
    @SerializedName("nama_barang") private String nama_barang;
    @Expose
    @SerializedName("jenis_barang") private String jenis_barang;
    @Expose
    @SerializedName("stok") private String stok;

    public String getNama_barang(){ return nama_barang; }
    public String getJenis_barang(){ return jenis_barang; }
    public String getStok(){ return stok; }

    public void setNama_barang(){ this.nama_barang = nama_barang; }
    public void setJenis_barang(){ this.jenis_barang = jenis_barang; }
    public void setStok(){ this.stok = stok; }
}
